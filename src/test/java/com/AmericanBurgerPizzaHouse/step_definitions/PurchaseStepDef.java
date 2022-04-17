package com.AmericanBurgerPizzaHouse.step_definitions;

import com.AmericanBurgerPizzaHouse.pages.BurgerPage;
import com.AmericanBurgerPizzaHouse.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseStepDef {

    BurgerPage burgerPage = new BurgerPage();
    protected String AddedProduct;

    @When("user click {string} tab")
    public void user_click_tab(String choosenProduct) {
        AddedProduct = choosenProduct;
        burgerPage.burgerMenuProducts(choosenProduct).click();
        BrowserUtils.waitForVisibility(burgerPage.deliveryPickUpPopUp, 3);
    }

    @And("user choose pickup option from open popup and confirm")
    public void userChoosePickupOptionFromOpenPopupAndConfirm() {
        burgerPage.pickUpButton.click();
        burgerPage.pickUpConfirmButton.click();
    }

    @And("user clicks confirm button from product pop-up")
    public void userClicksConfirmButtonFromProductPopUp() {
        burgerPage.choiceConfirmButton.click();
    }

    @Then("product added to shopping cart")
    public void productAddedToShoppingCart() {
        String addedProductInfo = burgerPage.addedProductInfo.getText();
        Assert.assertTrue(addedProductInfo.contains(AddedProduct));

    }

    @And("total price is calculated with discount")
    public void totalPriceIsCalculatedWithDiscount() {
        double ActualTotalPrice = burgerPage.getSubtotalPrice() - (burgerPage.getSubtotalPrice() * 10 / 100);
        double ExpectedTotalPrice = burgerPage.getTotalPrice();
        Assert.assertEquals(ExpectedTotalPrice, ActualTotalPrice);
    }
}
