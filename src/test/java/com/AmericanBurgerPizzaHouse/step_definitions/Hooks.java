package com.AmericanBurgerPizzaHouse.step_definitions;

import com.AmericanBurgerPizzaHouse.utilities.ConfigurationReader;
import com.AmericanBurgerPizzaHouse.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //before and after suites will execute before and after of each tet case...
    //coming from cucumber

    @Before
    public void setUp(){
        //maximize the window
        Driver.get().manage().window().maximize();
        //wait for each driver actions to perform
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){ //if scenario fails, this condition takes screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        //close the running Singleton driver object
        Driver.closeDriver();

    }
}
