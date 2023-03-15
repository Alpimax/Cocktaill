package com.alpi.step_definitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class Hooks {
    @Before("@API")
    public static void init() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

}
