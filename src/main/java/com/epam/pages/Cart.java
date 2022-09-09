package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Cart  extends BasePage {

    @FindBy(className = "btn-add")
    private List<WebElement> addToOrder;

    @FindBy(xpath = "//div[@class='item']")
    private List<WebElement> getItems;


    public Cart(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToOrder() {
        addToOrder.get(1).click();
    }

    public String getTittleAddItem(int item) {
        return  driver.findElement(By.xpath("((//a[@class='btn-add'])["+item+"]/following::a)[2]")).getText();
    }

    public WebElement getTittleItem(String tittle) {
        return driver.findElement(By.xpath("//div[@class='item']//span[contains(text(),'" + tittle + "')]"));
    }

    @Override
    public By getLocator(int i) {
        if (i == 1) {
            return By.xpath("(//div[@class='item'])[2]");
        }
        return null;
    }
}
