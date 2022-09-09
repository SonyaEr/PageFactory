package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    private By locator;

    public By getLocator(int i) {
        return locator;
    }

    public BasePage(WebDriver driver, By locator) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.locator = locator;
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibilityOfElement(long time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresenceOfElementLocated(long time, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
