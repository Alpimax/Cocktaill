package com.alpi.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;


public class Hooks {
    /** Base URI runs before send request
     *
     */
    @Before()
    public static void init() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

}
