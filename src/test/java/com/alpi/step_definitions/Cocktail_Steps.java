package com.alpi.step_definitions;


import io.cucumber.java.en.*;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Cocktail_Steps {
    static RequestSpecification reqSpec;
    static ValidatableResponse validResponse;
    static Response response;
    static JsonPath jsonPath;


    @Given("Accept type is {string}")
    public void acceptTypeIsApplication(String json) {
        reqSpec = given().accept(json);
    }

    @And("Query param  {string} is {string}")
    public void queryParamIIs(String key, String value) {
        reqSpec.queryParam(key, value);
    }

    @When("user send GET request to {string}")
    public void userSendGETRequestTo(String endPoint) {
        response = reqSpec.when().get(endPoint);
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        validResponse = response.then();
        validResponse.statusCode(statusCode);
    }

    @And("verify {string} with {string}")
    public void verifyWith(String ingredient, String ingredient_ID) {
        validResponse.body("ingredients[0].strIngredient", equalTo(ingredient))
                .body("ingredients[0].idIngredient", is(ingredient_ID));

    }

    @And("User should able to see {string}")
    public void userShouldAbleToSee(String description) {
        validResponse.body("ingredients[0].strDescription", startsWith(description));
    }

    @And("verify {string} is product")
    public void verifyIsProduct(String type) {
        validResponse.body("ingredients[0].strType", equalTo(type));
    }


    @And("If {string} is {string} {string} should not be null")
    public void ifIsShouldNotBeNull(String alcohol, String yes, String abv) {
        jsonPath = validResponse.extract().jsonPath();
        String statement = jsonPath.getString("ingredients[0].strAlcohol");
        if (statement.equals(yes)) {
            validResponse.body("ingredients[0].strABV", equalTo(abv));

        } else {
            validResponse.body("ingredients[0].strABV", nullValue());
            validResponse.body("ingredients[0].strAlcohol", equalTo(alcohol));
        }

    }

    @Then("search should return an {string}")
    public void search_should_return_an(String string) {
        validResponse.body("ingredients", nullValue());
    }


}
