package com.alpi.Junit_parameterized_test;

import com.alpi.Junit_utilities.CocktailTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public  class ParameterizedTestCase extends CocktailTestBase {


    @ParameterizedTest
    @CsvFileSource(resources = "/Cocktail_ingredient.csv", numLinesToSkip = 1)
    public void test1(String ingredients) {

        given().accept(ContentType.JSON).queryParam("i", ingredients).
                when().get("/search.php").
                then().statusCode(200).body("ingredients",notNullValue());

    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Cocktail_search.csv", numLinesToSkip = 1)
    public void test2(String cocktailSearch) {

        given().accept(ContentType.JSON).queryParam("s", cocktailSearch).
                when().get("/search.php").
                then().statusCode(200).body("drinks",notNullValue());

    }

}
