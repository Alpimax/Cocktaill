package com.alpi.step_definitions;

import com.alpi.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.apiguardian.api.API;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    @Before("@API")
    public static void init() {

        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

}
