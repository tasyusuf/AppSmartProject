package com.AmericanBurgerPizzaHouse.step_definitions;

import com.AmericanBurgerPizzaHouse.pages.PurchasePage;
import com.AmericanBurgerPizzaHouse.utilities.BrowserUtils;
import com.AmericanBurgerPizzaHouse.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PurchaseStepDef {

    PurchasePage purchasePage = new PurchasePage();
    protected String AddedProduct;

    @When("user click {string} tab")
    public void user_click_tab(String choosenProduct) {
        AddedProduct = choosenProduct;
        purchasePage.menuProducts(choosenProduct).click();
        BrowserUtils.waitForVisibility(purchasePage.deliveryPickUpPopUp, 3);
    }

    @And("user choose pickup option from open popup and confirm")
    public void userChoosePickupOptionFromOpenPopupAndConfirm() {
        purchasePage.pickUpButton.click();
        purchasePage.pickUpConfirmButton.click();
    }

    @And("user clicks confirm button from product pop-up")
    public void userClicksConfirmButtonFromProductPopUp() {
        purchasePage.choiceConfirmButton.click();
    }

    @Then("product added to shopping cart")
    public void productAddedToShoppingCart() {
        String addedProductInfo = purchasePage.addedProductInfo.getText();
        Assert.assertTrue(addedProductInfo.contains(AddedProduct));

    }

    @And("total price is calculated with discount")
    public void totalPriceIsCalculatedWithDiscount() {
        double ActualTotalPrice = purchasePage.getSubtotalPrice() - (purchasePage.getSubtotalPrice() * 10 / 100);
        double ExpectedTotalPrice = purchasePage.getTotalPrice();
        Assert.assertEquals(ExpectedTotalPrice, ActualTotalPrice, 0);
    }

    @When("user clicks Order Now button")
    public void userClicksOrderNowButton() {
        purchasePage.orderNowButton.click();
    }

    @And("Address & personal details cart is opened")
    public void addressPersonalDetailsCartIsOpened() {
        String ActualHeader = purchasePage.addressAndPersDetailHeader.getText();
        String ExpectedHeader = "Address & personal details";
        Assert.assertEquals(ExpectedHeader, ActualHeader);
    }

    @And("user fill the cart with personal information")
    public void userFillTheCartWithPersonalInformation() {
        BrowserUtils.waitForVisibility(purchasePage.firstName, 3);
        Faker faker = new Faker();
        purchasePage.firstName.sendKeys(faker.name().firstName());
        purchasePage.lastName.sendKeys(faker.name().lastName());
        purchasePage.companyName.sendKeys(faker.company().name());
        purchasePage.streetName.sendKeys(faker.address().streetName());
        purchasePage.streetNumber.sendKeys(faker.address().streetAddressNumber());
        purchasePage.zipCode.sendKeys("12345");
        purchasePage.city.sendKeys("Berlin");
        purchasePage.email.sendKeys("noOne@xmail.com");
        purchasePage.phone.sendKeys("1325689745");
        purchasePage.additionalInfo.sendKeys("I want my food hot and delicious!");
    }

    @And("clicks checkout")
    public void clicksCheckout() {
        purchasePage.checkoutButton.click();
    }

    @Then("user see the payment options")
    public void userSeeThePaymentOptions() {
        String ActualHeader = purchasePage.paymentCartHeader.getText();
        String ExpectedHeader = "Select your payment method";
        Assert.assertEquals(ExpectedHeader, ActualHeader);
    }
}
