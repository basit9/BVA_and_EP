package demo;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EquivalencePartitioningTests {


    @Test
    public void validPartitions(){

        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", 20)
                .toString();

        String response = given()
                .baseUri("https://*********/demo")
                .when()
                .body(jsonPayload)
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
        JSONObject json = new JSONObject(response);
        Assert.assertEquals("John, you are eligible for sign up.",json.getString("msg"));
        System.out.println(response);
    }

    @Test
    public void lowerInvalidPartitions(){

        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", 10)
                .toString();

        String response = given()
                .baseUri("https://*********/demo")
                .when()
                .body(jsonPayload)
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
        System.out.println(response);
    }

    @Test
    public void higherInvalidPartitions(){

        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", 70)
                .toString();

        String response = given()
                .baseUri("https://api.abdul-basit.com/demo")
                .when()
                .body(jsonPayload)
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
        System.out.println(response);
    }
}
