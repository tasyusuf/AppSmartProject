package com.AmericanBurgerPizzaHouse.pages;

import com.AmericanBurgerPizzaHouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage{

    //locators related to main page
    @FindBy(xpath = "//div[@class='LanguageSwitcher__head']")
    public WebElement LanguageDropdown;

    @FindBy(xpath = "//ul[@class='LanguageSwitcher__list']")
    public WebElement LanguageList;

    @FindBy(xpath = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li")
    public List<WebElement> AllLanguages;

    @FindBy(xpath = "//div[@id='app-wrapper']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/a")
    public List<WebElement> ActualMenuOptions;


    @FindBy(xpath = "//body/div[@id='app']/div[@id='app-wrapper']/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    public WebElement angeboteTitle;

    @FindBy(xpath = "//div[contains(text(),'Getränke | Alkoholfrei')]")
    public WebElement GetrankeTitle;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[contains(text(),'Sorry, no products were found.')]")
    public WebElement EmptySearchResultText;

    @FindBy(xpath = "//div[@id='app-wrapper']/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]")
    public WebElement ResetSearchButton;

    //this method get language options and return options in List
    public List<String> getLanguageText(){
        String[] split = LanguageList.getText().split("\n");
        return Arrays.asList(split);
    }
    //this method returns choosen language
    public WebElement chooseLanguage(){
        Random rn = new Random();
        //choose a random language in 4 language options
        String path = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li[" + (rn.nextInt(4)+1) + "]";
        WebElement language = Driver.get().findElement(By.xpath(path));

        //this loop changes the choosen language if the language is same with the active language
        while(language.equals(Driver.get().findElement(By.xpath("//li[contains(@class,'LanguageSwitcher__item_active')]")))){

            path = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li[" + (rn.nextInt(4)+1) + "]";
            language = Driver.get().findElement(By.xpath(path));

            if(!language.equals(Driver.get().findElement(By.xpath("//li[contains(@class,'LanguageSwitcher__item_active')]")))){
                break;
            }
        }
        return language;
    }

    /*
    @param option
    this method takes the menu name as parameter and returns Webelement
     */
    public WebElement clicktheMenu(String option){
        return Driver.get().findElement(By.linkText(option));
    }
    /*
        @param option
        this method takes the menu name as parameter and returns title Webelement
    */
    public WebElement getMenuTitle(String option){
        return Driver.get().findElement(By.xpath("//div[contains(text(),'"+option+"')]"));
    }
    /*
            @param option
            this method takes the sub-menu name of Getranke as parameter and returns webelement of Getranke sub-menu
    */
    public WebElement clicktheGetrankeMenu(String option){
        return Driver.get().findElement(By.xpath("//span[contains(text(),'"+option+"')]"));
    }
    /*
                @param option
                this method takes the searching item as parameter and returns title of search result
    */
    public WebElement searchResultText(String Option){
        return Driver.get().findElement(By.xpath("//div[contains(text(),\"Search results for '"+Option+"'\")]"));
    }

}

