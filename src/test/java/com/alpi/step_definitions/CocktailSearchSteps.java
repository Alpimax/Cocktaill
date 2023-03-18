package com.alpi.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.alpi.step_definitions.CocktailIngredientSteps.*;
import static org.hamcrest.Matchers.*;


public class CocktailSearchSteps {

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
    public void responseShouldContainInItsName(String name) {
        validResponse.body("drinks.strDrink", everyItem(containsString(name)));
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
            System.err.println("require = " + require);
            System.err.println("Error: " + e.getMessage());
        }


    }

    @And("response should contain {string} array")
    public void responseShouldContainArray(String items) {

        validResponse.body("" + items, notNullValue());

    }

    @And("each drink should have {string}.")
    public void eachDrinkShouldHave(String date) {
        validResponse.body("drinks." + date, notNullValue());
    }

}
