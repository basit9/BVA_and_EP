# Use the Maven image with Amazon Corretto 18 as the base
FROM maven:3.8.6-amazoncorretto-18 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (caching step)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src /app/src

# Run tests and package the application
RUN mvn clean test package

# Copy test results to a location for report generation (optional)
RUN cp -r target/surefire-reports /app/surefire-reports

# Generate the report based on the test results (tests run only once)
RUN mvn surefire-report:report-only

# Compile the SimpleHttpServer and MyHandler classes
RUN mvn compile

# Expose the port the server will run on
EXPOSE 8080

# Command to run tests and start the server, even if tests fail
CMD ["sh", "-c", "mvn clean test || true && mvn -Dmaven.test.skip=true surefire-report:report && java -cp target/classes com.basit.HttpServer 8080"]
