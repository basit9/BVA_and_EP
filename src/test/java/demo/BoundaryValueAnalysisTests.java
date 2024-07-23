package demo;

import demo.Models.QueryParamData;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class BoundaryValueAnalysisTests {

    private static Stream<QueryParamData> lowerBoundaries() {
        return Stream.of(
                new QueryParamData("age", 17),
                new QueryParamData("age", 18),
                new QueryParamData("age", 19)
        );
    }

    private static Stream<QueryParamData> higherBoundaries() {
        return Stream.of(
                new QueryParamData("age", 49),
                new QueryParamData("age", 50),
                new QueryParamData("age", 51)
        );
    }

    @ParameterizedTest()
    @MethodSource({"lowerBoundaries","higherBoundaries"})
    public void boundariesTests(QueryParamData params){

        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", params.value())
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

}
