package com.AmericanBurgerPizzaHouse.pages;

import com.AmericanBurgerPizzaHouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchasePage extends BasePage{

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

    @FindBy(xpath = "//button[contains(text(),'Order now')]")
    public WebElement orderNowButton;

    @FindBy(xpath = "//div[3]/div[2]/div[1]/div[3]/div[1]")
    public WebElement addressAndPersDetailHeader;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyName;

    @FindBy(xpath = "//input[@id='street']")
    public WebElement streetName;

    @FindBy(xpath = "//input[@id='street_no']")
    public WebElement streetNumber;

    @FindBy(xpath = "//input[@id='zip']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement additionalInfo;

    @FindBy(xpath = "//form[1]/div[11]/button[1]")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[contains(text(),'Select your payment method')]")
    public WebElement paymentCartHeader;

    @FindBy(xpath = "//h5[contains(text(),'Nachos')]")
    public List<WebElement> nachosOptions;



    public WebElement menuProducts(String option){
        return Driver.get().findElement(By.xpath("//h5[contains(text(),'"+option+"')]"));
    }

    public double getSubtotalPrice(){
        String subPrice = subtotalPrice.getText().substring(0, subtotalPrice.getText().length() - 2);
        subPrice = subPrice.replace(",", ".");
        return Double.parseDouble(subPrice);
    }

    public double getdiscountrate(){
        String discountPrice = discount.getText().substring(1, discount.getText().length() - 1);
        discountPrice = discountPrice.replace(",", ".");
        return Double.parseDouble(discountPrice);
    }

    public double getTotalPrice(){
        String totPrice = totalPrice.getText().substring(0, totalPrice.getText().length() - 2);
        totPrice = totPrice.replace(",", ".");
        return Double.parseDouble(totPrice);
    }
}
