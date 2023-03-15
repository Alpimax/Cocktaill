package com.alpi.step_definitions;


import io.cucumber.java.en.*;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.*;


public class CocktailApiTestSteps {


    private Response response;

    @Given("I have a valid ingredient  {string}")
    public void i_have_a_valid_ingredient_name(String name) {
        System.out.println("Running for " + name);
    }


    @When("I search for the ingredient by  {string}")
    public void i_search_for_the_ingredient_by_name(String name) {
        response = given().accept(ContentType.JSON).queryParam("i", name).when().get("/search.php");
    }

    @Then("the search results should include the following fields {string},{string},{string},{string},{string},{string}")
    public void the_search_results_should_include_the_following_fields(String id, String ingredient, String description, String type, String alcohol, String abv) {
        JsonPath jsonPath = response.jsonPath();
        System.out.println("Closing for " + ingredient);

        assertEquals(id, jsonPath.getString("ingredients[0].idIngredient"));
        assertEquals(ingredient, jsonPath.getString("ingredients[0].strIngredient"));
        assertTrue(jsonPath.getString("ingredients[0].strDescription").startsWith(description));
        assertEquals(type, jsonPath.getString("ingredients[0].strType"));

        if (jsonPath.getString("ingredients[0].strAlcohol").equals("No")) {
            assertEquals(alcohol, jsonPath.getString("ingredients[0].strAlcohol"));
            assertNull(jsonPath.getString("ingredients[0].strABV"));
        } else {
            assertEquals(alcohol, jsonPath.getString("ingredients[0].strAlcohol"));
            assertEquals(abv, jsonPath.getString("ingredients[0].strABV"));
        }

    }

    @Given("I have an invalid ingredient {string}")
    public void i_have_an_invalid_ingredient(String name) {
        System.out.println("Running for " + name);
    }

    @When("I search for the ingredient by {string}")
    public void i_search_for_the_ingredient_by(String name) {
        response = given().accept(ContentType.JSON).queryParam("i", name).when().get("/search.php");
    }

    @Then("Search should return an {string}")
    public void search_should_return_an(String string) {
        JsonPath jsonPath = response.jsonPath();
        assertNull(string, jsonPath.getString("ingredients"));
    }
}
