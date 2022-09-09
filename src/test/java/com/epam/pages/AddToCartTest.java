package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest {

    private final String SEARCH_KEYWORD = "samsung";

    @Test(priority = 1)
    public void checkAddToOrder() {
        getHeader().searchByKeyword(SEARCH_KEYWORD);
        getSamsungPage().clickOnAddToCartButton(1);
        getSamsungPage().waitForVisibilityOfElement(3, getSamsungPage().getCartPopup());
        getCart().clickOnAddToOrder(1);
        getCart().waitForPresenceOfElementLocated(3, getCart().getLocator(1, 2));
        String tittle = getCart().getTitleAddItem(1);
        WebElement el = getCart().getTitleItem(tittle);
        assertTrue(el.isDisplayed());
    }

    @Test(priority = 2)
    public void checkAmountAfterAddQuantity() {
        getHeader().searchByKeyword(SEARCH_KEYWORD);
        getSamsungPage().clickOnAddToCartButton(1);
        getSamsungPage().waitForVisibilityOfElement(3, getSamsungPage().getCartPopup());
        String totalPriceOld = getCart().getTotalPrice();
        getCart().clickOnAddToOrder(1);
        getCart().waitForElementToBeClickable(3, getCart().getLocator(2, 1));
        getCart().clickOnPlus(1);
        getCart().waitForChangeTotalPrice(totalPriceOld);
        List<WebElement> prices = getCart().getItemPrices();
        int numberNew = 0;
        for (int i = 0; i < prices.size(); i++) {
            String[] part = prices.get(i).getText().split(" ");
            if (part.length != 2) {
                throw new IllegalArgumentException();
            }
            int totalH = Integer.parseInt(part[0]);
            int count = getCart().getCountOfItem(i);
            numberNew = numberNew + totalH * count;
        }
        String totalPrice = getCart().getTotalPrice();
        String[] part2 = totalPrice.split(" ");
        if (part2.length != 2) {
            throw new IllegalArgumentException();
        }
        int number = Integer.parseInt(part2[0]);
        assertEquals(numberNew, number);
    }

    @Test(priority = 3)
    public void checkCartSignIn() {
        getHeader().clickOnShoppingCart();
        getHomePage().waitForVisibilityOfElement(2, getSamsungPage().getCartPopup());
        getCart().clickLogin();
        assertEquals(getLoginPage().getTitle(), "Вхід та реєстрація");
    }


}

