package com.basit;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        String reportsDir = "target/site";  // Directory where the reports are generated

        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler(reportsDir));
        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("Server started on port " + port + ", serving files from " + reportsDir);
    }

    static class MyHandler implements HttpHandler {
        private final String reportsDir;

        public MyHandler(String reportsDir) {
            this.reportsDir = reportsDir;
        }

        @Override
        public void handle(HttpExchange t) throws IOException {
            String path = t.getRequestURI().getPath();
            File file = new File(reportsDir + path);

            if (file.isDirectory()) {
                // Serve index.html by default
                file = new File(file, "surefire-report.html");
            }

            if (file.exists()) {
                t.sendResponseHeaders(200, file.length());
                FileInputStream fis = new FileInputStream(file);
                OutputStream os = t.getResponseBody();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                fis.close();
            } else {
                // File not found
                String response = "404 (Not Found)\n";
                t.sendResponseHeaders(404, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
