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

    String choosenLanguage;

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        //ConfigurationReader takes the url from central place(configuration.properties)
        Driver.get().get(ConfigurationReader.get("url"));
        //BrowserUtils.waitFor(2);
    }

    @When("user clicks the language abbreviation on the main page")
    public void user_clicks_the_language_abbreviation_on_the_main_page() {
        //take the choosen language at the beginning and assign it to instance variable
        choosenLanguage = mainPage.LanguageDropdown.getText();
        //click language dropdown
        mainPage.LanguageDropdown.click();
        //BrowserUtils.waitFor(1);
    }
    @When("user see the language options dropdown with options below")
    public void user_see_the_language_options_dropdown_with_options_below(List<String> ExpectedLanguageOptions) {
        //verify actual language options from UI matches with expected ones
        Assert.assertEquals(ExpectedLanguageOptions, mainPage.getLanguageText());
    }


    @Then("user choose the language")
    public void userChooseTheLanguage() {
        //change/choose the language
        mainPage.chooseLanguage().click();
       BrowserUtils.waitFor(2);
    }


    @And("language abbreviation changes")
    public void languageAbbreviationChanges() {
        //verify language is not same with the default one
        Assert.assertFalse(choosenLanguage.contains(mainPage.LanguageDropdown.getText()));
    }

    @When("user see the menu options below")
    public void user_see_the_menu_options_below(List<String> ExpectedMenuTable) {
        //takes actual manu list from webpage
        List<String> ActualMenuTable = BrowserUtils.getElementsText(mainPage.ActualMenuOptions);
        //verify menu table is same with the expected menu list
        Assert.assertEquals(ExpectedMenuTable, ActualMenuTable);
    }

    @When("user clicks {string} on main menu table")
    public void userClicksOnMainMenuTable(String Option) {
        //click a desired menu
        mainPage.clicktheMenu(Option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("menu title displays Angebote")
    public void menuTitleDisplaysAngebote() {
        //get angebote menu title from page
        String ActualTitle = mainPage.angeboteTitle.getText();
        String ExpectedTitle = "Angebote";
        //verify angebote title matches with the expected one
        Assert.assertEquals("Titles ar matching", ExpectedTitle, ActualTitle);
    }

    @Then("menu title displays Getränke | Alkoholfrei")
    public void menuTitleDisplaysGetränkeAlkoholfrei() {
        //get Getranke menu title from page
        String ActualTitle = mainPage.GetrankeTitle.getText();
        String ExpectedTitle = "Getränke | Alkoholfrei";
        //verify Getranke title matches with the expected one
        Assert.assertEquals("Titles are matching", ExpectedTitle, ActualTitle);
    }

    @When("user clicks {string} on the menu table")
    public void userClicksOnTheMenuTable(String option) {
        //click a desired menu (except Getranke and angebote)
        mainPage.clicktheMenu(option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("the title displays {string}")
    public void theTitleDisplays(String ExpectedTitle) {
        //get the related menu title from page
        String ActualTitle = mainPage.getMenuTitle(ExpectedTitle).getText();
        //verify title matches with the expected one
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @And("user clicks the {string} tab")
    public void userClicksTheTab(String option) {
        //click getranke menu options (4 option)
        mainPage.clicktheGetrankeMenu(option).click();
        BrowserUtils.waitFor(1);
    }

    @Then("menu title contains {string}")
    public void menuTitleContains(String ExpectedTitle) {
        //get Getranke menu title from page
        String ActualTitle = mainPage.getMenuTitle(ExpectedTitle).getText();
        //verify title contains sub-menu name
        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
    }

    @When("user search a desired {string}")
    public void userSearchADesired(String searchingProduct) {
        //search a product
        mainPage.searchBox.sendKeys(searchingProduct + Keys.ENTER);
    }

    @Then("search result is shown for {string}")
    public void searchResultIsShownFor(String searchingProduct) {
        String ExpectedText = "Search results for '" + searchingProduct + "'";
        //get the search results header from webpage
        String ActualText = mainPage.searchResultText(searchingProduct).getText();
        //verify matches with expected message
        Assert.assertEquals(ExpectedText, ActualText);
    }

    @And("{string} message is displayed")
    public void messageIsDisplayed(String ExpectedMessage) {
        //get the search result for invalid product
        String ActualMessage = mainPage.EmptySearchResultText.getText();
        //verify message is matches with expected message
        Assert.assertEquals("Same message", ExpectedMessage, ActualMessage);
    }

    @And("Reset Search button is displayed")
    public void resetSearchButtonIsDisplayed() {
        //verify reset search button is displayed
        Assert.assertTrue(mainPage.ResetSearchButton.isEnabled());
    }
}
