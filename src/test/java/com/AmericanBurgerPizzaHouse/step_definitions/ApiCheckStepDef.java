package com.AmericanBurgerPizzaHouse.step_definitions;

import com.AmericanBurgerPizzaHouse.pages.PurchasePage;
import com.AmericanBurgerPizzaHouse.utilities.BrowserUtils;
import com.AmericanBurgerPizzaHouse.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ApiCheckStepDef {

    PurchasePage purchasePage = new PurchasePage();
    @Then("user see the below options related to Nachos menu")
    public void user_see_the_below_options_related_to_Nachos_menu(List<String> expectedMenuOptions) {
        List<WebElement> nachosOptions = purchasePage.nachosOptions;
        List<String>  actualMenuOptions = BrowserUtils.getElementsText(nachosOptions);
        Assert.assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Then("API response match with the below Nachos menu")
    public void api_response_match_with_the_below_Nachos_menu(List<String> expectedMenuOptions) {

        Response response = RestAssured.given().accept(ContentType.JSON).
                when()
                .get("https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-products-of-category/159/2950");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.getHeader("Connection"), "Keep-Alive");

        List<String> actualMenuOptions = response.path("d.name");
        Assert.assertEquals(expectedMenuOptions, actualMenuOptions);

    }
}
