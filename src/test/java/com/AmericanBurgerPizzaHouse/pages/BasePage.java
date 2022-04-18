package com.AmericanBurgerPizzaHouse.pages;

import com.AmericanBurgerPizzaHouse.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
/*
cannot be created an object.Central page for features or elements repeated or unchangable
within all pages
*/
public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
