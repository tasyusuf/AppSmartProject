package com.AmericanBurgerPizzaHouse.step_definitions;

import com.AmericanBurgerPizzaHouse.pages.MainPage;
import com.AmericanBurgerPizzaHouse.utilities.BrowserUtils;
import com.AmericanBurgerPizzaHouse.utilities.ConfigurationReader;
import com.AmericanBurgerPizzaHouse.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class MainPageStepDef {

    MainPage mainPage = new MainPage();

    protected String ChoosenLanguage;

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
    }

    @When("user clicks the language abbreviation on the main page")
    public void user_clicks_the_language_abbreviation_on_the_main_page() {
        ChoosenLanguage = mainPage.LanguageDropdown.getText();
        mainPage.LanguageDropdown.click();
        BrowserUtils.waitFor(1);
    }
    @When("user see the language options dropdown with options below")
    public void user_see_the_language_options_dropdown_with_options_below(List<String> ExpectedLanguageOptions) {
        Assert.assertEquals(ExpectedLanguageOptions, mainPage.getElementText());

    }


    @Then("user choose the language")
    public void userChooseTheLanguage() {
        mainPage.chooseLanguage().click();
       BrowserUtils.waitFor(2);
    }


    @And("language abbreviation changes")
    public void languageAbbreviationChanges() {
        Assert.assertFalse(ChoosenLanguage.contains(mainPage.LanguageDropdown.getText()));
    }
}
