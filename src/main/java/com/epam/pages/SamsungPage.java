package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SamsungPage extends BasePage {

    @FindBy(className = "prod-cart__buy")
    private List<WebElement> addToCartButton;

    @FindBy(id = "js_cart")
    private WebElement cartPopup;

    public SamsungPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.get(0).click();
    }

    public WebElement getCartPopup() {
        return cartPopup;
    }

}
