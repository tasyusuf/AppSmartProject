package com.AmericanBurgerPizzaHouse.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
Cukes runner is to run my scenarios.
It also includes cucumber options report plugins and path of feature file to trigger test cases.
Path of step definitions and “tags” which will run.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/AmericanBurgerPizzaHouse/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {

}
