package com.alpi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features" ,
        glue = "com/alpi/step_definitions",
        dryRun = false,
        tags = "@Cocktail"
)
public class Runner {

}


