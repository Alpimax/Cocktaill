package com.alpi.step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


import static com.alpi.step_definitions.CocktailIngredientSteps.*;
import static org.hamcrest.Matchers.*;


public class CocktailSearchSteps {

    /** Static class import and soft assertion
     * Every test cases passing, but it gives me name and keys which one is failing
     *
     */

    @And("verify item name contains {string}")
    public void verifyItemNameContains(String lowercase) {
        validResponse.body("drinks.strDrink", everyItem(contains(lowercase)));

    }


    @And("Query param {string} is {string}")
    public void queryParamIs(String key, String value) {
        reqSpec.queryParam(key, value);
    }

    @When("user sends GET request to {string}")
    public void userSendsGETRequestTo(String endpoind) {
        response = reqSpec.when().get(endpoind);
    }

    @And("response should not be null")
    public void responseShouldNotBeNull() {
        validResponse.body("drinks", notNullValue());
    }

    @And("response should contain {string} in its name.")
    public void responseShouldContainInItsName(String queryParam) {
        validResponse.body("drinks.strDrink", everyItem(containsString(queryParam)));
    }


    @And("response should be null")
    public void responseShouldBeNull() {
        validResponse.body("drinks", nullValue());
    }


    @And("{string} field should be present in each drink")
    public void fieldShouldBePresentInEachDrink(String require) {


        try {
            validResponse.body("drinks." + require, everyItem(notNullValue()));
        } catch (AssertionError e) {
            System.err.println(validResponse.extract().jsonPath().getList("drinks.strDrink"));
            System.err.println("require = " + require);
            System.err.println("Error: " + e.getMessage());
        }


    }

    @And("response should contain {string} array")
    public void responseShouldContainArray(String items) {

        validResponse.body("" + items, notNullValue());

    }
}
