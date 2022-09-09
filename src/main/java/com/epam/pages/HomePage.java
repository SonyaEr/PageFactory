package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {


    @FindBy(xpath = "//div[@class='menu-lvl first-level']/ul/li[@class='parent js_sidebar-item']")
    private  List<WebElement> menu;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement>  getMenu() {
        return menu;
    }

    public String getHrefMenu(int sectionMenu) {
        return driver.findElement(By.xpath("(//div[@class='menu-lvl first-level']/ul/li[@class='parent js_sidebar-item']/a)[" + sectionMenu + "+1]")).getAttribute("href");
    }

    public List<WebElement> getFirstSubMenu(int sectionMenu) {
        return  driver.findElements(xpath("(//div[@class='menu-lvl second-level next-level js_next-level'])[" + sectionMenu + "+1]/ul/li[@class='parent js_sidebar-item']"));
    }

    public String getHrefFirstSubMenu(int sectionMenu, int sectionFirstSubMenu) {
        return driver.findElement(By.xpath("((//div[@class='menu-lvl second-level next-level js_next-level'])[" + sectionMenu + "+1]/ul/li[@class='parent js_sidebar-item']/a)[" + sectionFirstSubMenu + "+1]")).getAttribute("href");
    }
    public List<WebElement> getSecondSubMenu(int sectionMenu, int sectionFirstSubMenu) {
        return  driver.findElements(xpath("((//ul[@class='sidebar-list'])[" + sectionMenu + "+1]/li[@class='parent js_sidebar-item'])[" + sectionFirstSubMenu + "+1]//li[@class='single-hover-block']/a"));
    }
    public String getHrefSecondSubMenu(int sectionMenu, int sectionFirstSubMenu,int sectionSecondSubMenu ) {
        return driver.findElement(xpath("(((//ul[@class='sidebar-list'])[" + sectionMenu + "+1]/li[@class='parent js_sidebar-item'])[" + sectionFirstSubMenu + "+1]//li[@class='single-hover-block']/a)[" +sectionSecondSubMenu+ " +1]")).getAttribute("href");
    }







}