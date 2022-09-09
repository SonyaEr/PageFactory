package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    @FindBy(css = "button.button-reset.search-btn")
    private WebElement searchButton;

    @FindBy(id = ("input_search"))
    private WebElement searchInput;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

}
