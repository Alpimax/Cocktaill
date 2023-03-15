package com.alpi.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;


public class SchemaValidation {

    private Response response;

    @Given("the API is available for search {string}")
    public void the_api_is_available_for_search(String name) {
        System.out.println("Opening for " + name);
    }

    @When("I search for a cocktail by name {string}")
    public void i_search_for_a_cocktail_by_name(String name) {
        response = given().accept(ContentType.JSON).queryParam("s", name).when().get("/search.php");

    }
    @Then("the API returns a response with a valid schema")
    public void the_api_returns_a_response_with_a_valid_schema() {

        // schema validation
        response.then().statusCode(200).body(matchesJsonSchemaInClasspath("SearchSchemaValidation.json"));
    }

    @When("I search for a cocktail by an invalid name {string}")
    public void i_search_for_a_cocktail_by_an_invalid_name(String invalidname) {
        response = given().accept(ContentType.JSON).queryParam("s", invalidname).when().get("/search.php");
    }

    @Then("the API returns a response with an error message")
    public void the_api_returns_a_response_with_an_error_message() {
        JsonPath jsonPath = response.then().statusCode(200).extract().jsonPath();
        assertNull(jsonPath.getString("drinks"));
    }


}
