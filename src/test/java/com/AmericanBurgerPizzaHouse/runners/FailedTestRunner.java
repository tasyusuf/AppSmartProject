package com.AmericanBurgerPizzaHouse.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//For failed tests, my framework has failed test runner as well.

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/AmericanBurgerPizzaHouse/step_definitions"
)
public class FailedTestRunner {
}
