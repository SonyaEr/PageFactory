package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeClass
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SamsungPage getSamsungPage() {
        return new SamsungPage(getDriver());
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public Header getHeader() {
        return new Header(getDriver());
    }

    public Cart getCart() {
        return new Cart(getDriver());
    }



}
