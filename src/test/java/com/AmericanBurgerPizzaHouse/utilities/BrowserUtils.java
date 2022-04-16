package com.AmericanBurgerPizzaHouse.utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtils {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
