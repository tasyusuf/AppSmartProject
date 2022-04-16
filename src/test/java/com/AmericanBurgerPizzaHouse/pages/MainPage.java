package com.AmericanBurgerPizzaHouse.pages;

import com.AmericanBurgerPizzaHouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class='LanguageSwitcher__head']")
    public WebElement LanguageDropdown;

    @FindBy(xpath = "//ul[@class='LanguageSwitcher__list']")
    public WebElement LanguageList;

    @FindBy(xpath = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li")
    public List<WebElement> AllLanguages;

    public List<String> getElementText(){
        String[] split = LanguageList.getText().split("\n");
        return Arrays.asList(split);
    }

    public WebElement chooseLanguage(){
        Random rn = new Random();

        String path = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li[" + (rn.nextInt(4)+1) + "]";

        WebElement language = Driver.get().findElement(By.xpath(path));

        while(language.equals(Driver.get().findElement(By.xpath("//li[contains(@class,'LanguageSwitcher__item_active')]")))){

            path = "//div[@id='app-wrapper']/div/div[2]/div/div/div/div[2]/ul/li[" + (rn.nextInt(4)+1) + "]";

            language = Driver.get().findElement(By.xpath(path));

            if(!language.equals(Driver.get().findElement(By.xpath("//li[contains(@class,'LanguageSwitcher__item_active')]")))){
                break;
            }
        }

        return language;

    }


    }

