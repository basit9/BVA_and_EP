package demo.Tests;

import demo.Data.BoundaryValue.HigherBoundaryData;
import demo.Data.BoundaryValue.LowerBoundaryData;
import demo.Models.QueryParamData;
import demo.Validations.Validations;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static io.restassured.RestAssured.given;

public class BoundaryValueAnalysisTest {

    private final Validations validationService = new Validations();

    @ParameterizedTest
    @MethodSource("provideBoundaryData")
    public void boundariesTests(QueryParamData params) {
        String jsonPayload = new JSONObject()
                .put("name", "Alex")
                .put("age", params.value())
                .toString();

        String response = given()
                .baseUri("https://api.abdul-basit.com/private/demo")
                .when()
                .body(jsonPayload)
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract().response().asString();
        validationService.validateAgeResponse(params, response);
    }

    static Stream<QueryParamData> provideBoundaryData() {
        return Stream.concat(
                new LowerBoundaryData().getData(),
                new HigherBoundaryData().getData()
        );
    }
}
