package com.alpi.Junit_utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class CocktailTestBase  {
    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";

    }
}
