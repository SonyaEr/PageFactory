package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest {

    private final String SEARCH_KEYWORD = "samsung";

    @Test(priority = 1)
    public void checkAddToOrder() {
        getHeader().searchByKeyword(SEARCH_KEYWORD);
        getSamsungPage().clickOnAddToCartButton();
        getSamsungPage().waitForVisibilityOfElement(3, getSamsungPage().getCartPopup());
        getCart().clickOnAddToOrder();
        getCart().waitForPresenceOfElementLocated(3, getCart().getLocator(1));
        String tittle = getCart().getTittleAddItem(1);
        WebElement el = getCart().getTittleItem(tittle);
        assertTrue(el.isDisplayed());
    }


}

