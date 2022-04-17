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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class MainPageStepDef {

    MainPage mainPage = new MainPage();

    protected String choosenLanguage;

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        //BrowserUtils.waitFor(2);
    }

    @When("user clicks the language abbreviation on the main page")
    public void user_clicks_the_language_abbreviation_on_the_main_page() {
        choosenLanguage = mainPage.LanguageDropdown.getText();
        mainPage.LanguageDropdown.click();
        //BrowserUtils.waitFor(1);
    }
    @When("user see the language options dropdown with options below")
    public void user_see_the_language_options_dropdown_with_options_below(List<String> ExpectedLanguageOptions) {
        Assert.assertEquals(ExpectedLanguageOptions, mainPage.getLanguageText());

    }


    @Then("user choose the language")
    public void userChooseTheLanguage() {
        mainPage.chooseLanguage().click();
       BrowserUtils.waitFor(2);
    }


    @And("language abbreviation changes")
    public void languageAbbreviationChanges() {
        Assert.assertFalse(choosenLanguage.contains(mainPage.LanguageDropdown.getText()));
    }

    @When("user see the menu options below")
    public void user_see_the_menu_options_below(List<String> ExpectedMenuTable) {
        List<String> ActualMenuTable = BrowserUtils.getElementsText(mainPage.ActualMenuOptions);
        Assert.assertEquals(ExpectedMenuTable, ActualMenuTable);
    }

    @When("user clicks {string} on main menu table")
    public void userClicksOnMainMenuTable(String Option) {
        mainPage.clicktheMenu(Option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("menu title displays Angebote")
    public void menuTitleDisplaysAngebote() {
        String ActualTitle = mainPage.angeboteTitle.getText();
        String ExpectedTitle = "Angebote";
        Assert.assertEquals("Titles ar matching", ExpectedTitle, ActualTitle);
    }

    @Then("menu title displays Getränke | Alkoholfrei")
    public void menuTitleDisplaysGetränkeAlkoholfrei() {
        String ActualTitle = mainPage.GetrankeTitle.getText();
        String ExpectedTitle = "Getränke | Alkoholfrei";
        Assert.assertEquals("Titles are matching", ExpectedTitle, ActualTitle);
    }

    @When("user clicks {string} on the menu table")
    public void userClicksOnTheMenuTable(String option) {
        mainPage.clicktheMenu(option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("the title displays {string}")
    public void theTitleDisplays(String ExpectedTitle) {
        String ActualTitle = mainPage.getMenuTitle(ExpectedTitle).getText();
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @And("user clicks the {string} tab")
    public void userClicksTheTab(String option) {
        mainPage.clicktheGetrankeMenu(option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("menu title contains {string}")
    public void menuTitleContains(String ExpectedTitle) {
        String ActualTitle = mainPage.getMenuTitle(ExpectedTitle).getText();
        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
    }

    @When("user search a desired {string}")
    public void userSearchADesired(String searchingProduct) {
        mainPage.searchBox.sendKeys(searchingProduct + Keys.ENTER);
    }

    @Then("search result is shown for {string}")
    public void searchResultIsShownFor(String searchingProduct) {
        String ExpectedText = "Search results for '" + searchingProduct + "'";
        String ActualText = mainPage.searchResultText(searchingProduct).getText();
        Assert.assertEquals(ExpectedText, ActualText);
    }

    @And("{string} message is displayed")
    public void messageIsDisplayed(String ExpectedMessage) {
        String ActualMessage = mainPage.EmptySearchResultText.getText();
        Assert.assertEquals("Same message", ExpectedMessage, ActualMessage);
    }

    @And("Reset Search button is displayed")
    public void resetSearchButtonIsDisplayed() {
        Assert.assertTrue(mainPage.ResetSearchButton.isEnabled());
    }
}
