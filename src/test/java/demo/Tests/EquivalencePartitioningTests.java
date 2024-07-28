package demo.Tests;

import demo.Data.Partitions.PartitionsData;
import demo.Models.QueryParamData;
import demo.Validations.Validations;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static io.restassured.RestAssured.given;

public class EquivalencePartitioningTests {

    private final Validations validationService = new Validations();

    static Stream<QueryParamData> providePartitionsTestData() {
        return new PartitionsData().getData();
    }

    @ParameterizedTest
    @MethodSource("providePartitionsTestData")
    public void partitions(QueryParamData params) {

        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", params.value())
                .toString();

        String response = given()
                .baseUri("https://************/demo")
                .when()
                .body(jsonPayload)
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
        validationService.validateAgeResponse(params, response);
    }
}