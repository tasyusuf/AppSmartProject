package com.AmericanBurgerPizzaHouse.pages;

import com.AmericanBurgerPizzaHouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgerPage extends BasePage{

    @FindBy(xpath = "//div[2]/div/div[6]/div/div")
    public WebElement deliveryPickUpPopUp;

    @FindBy(xpath = "(//div[@role='button'])[3]")
    public WebElement pickUpButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement pickUpConfirmButton;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement choiceConfirmButton;

    @FindBy(xpath = "//div[@id='basket-item']")
    public WebElement addedProductInfo;

    @FindBy(xpath = "//div[3]/div[3]/div[2]/div[1]/div[2]")
    public WebElement subtotalPrice;

    @FindBy(xpath = "//div[3]/div[3]/div[2]/div[2]/div[2]")
    public WebElement discount;

    @FindBy(xpath = "//div[3]/div[3]/div[2]/div[3]/div[2]")
    public WebElement totalPrice;




    public WebElement burgerMenuProducts(String option){
        return Driver.get().findElement(By.xpath("//h5[contains(text(),'"+option+"')]"));
    }

    public double getSubtotalPrice(){
        String subPrice = subtotalPrice.getText().substring(0, subtotalPrice.getText().length() - 1);
        return Double.parseDouble(subPrice);
    }

    public double getdiscountrate(){
        String discountPrice = discount.getText().substring(1, discount.getText().length() - 1);
        return Double.parseDouble(discountPrice);
    }

    public double getTotalPrice(){
        String totPrice = totalPrice.getText().substring(0, totalPrice.getText().length() - 1);
        return Double.parseDouble(totPrice);
    }
}
