package demo.Validations;

import demo.Models.QueryParamData;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class Validations {

    private static final int MIN_ELIGIBLE_AGE = 18;
    private static final int MAX_ELIGIBLE_AGE = 50;

    public void validateAgeResponse(QueryParamData input, String response) {
        JSONObject jsonResponse = new JSONObject(response);
        boolean isEligible = jsonResponse.getBoolean("eligible");

        if (input.value() < MIN_ELIGIBLE_AGE) {
            Assertions.assertFalse(isEligible, "Expected ineligible for age < " + MIN_ELIGIBLE_AGE);
        } else if (input.value() > MAX_ELIGIBLE_AGE) {
            Assertions.assertFalse(isEligible, "Expected ineligible for age > " + MAX_ELIGIBLE_AGE);
        } else {
            Assertions.assertTrue(isEligible, "Expected eligible for age between " + MIN_ELIGIBLE_AGE + " and " + MAX_ELIGIBLE_AGE);
        }
    }
}
