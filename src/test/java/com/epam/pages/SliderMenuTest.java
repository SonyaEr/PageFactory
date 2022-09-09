package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SliderMenuTest extends BaseTest {

    @Test
    public void checkSliderMenuHrefValid() {
        ArrayList<String> ref = new ArrayList<>();
        List<WebElement> menu = getHomePage().getMenu();
        for (int i = 0; i < menu.size(); i++) {
            getHomePage().actionsMoveToElement(menu.get(i));
            ref.add(getHomePage().getHrefMenu(i));
            List<WebElement> subMenu = getHomePage().getFirstSubMenu(i);
            for (int j = 0; j < subMenu.size(); j++) {
                ref.add(getHomePage().getHrefFirstSubMenu(i,j));
                List<WebElement> sub2Menu = getHomePage().getSecondSubMenu(i,j);
                for (int k = 0; k < sub2Menu.size(); k++) {
                    ref.add(getHomePage().getHrefSecondSubMenu(i,j,k));
                }
                getHomePage().actionsMoveToElement(subMenu.get(j));
            }
        }
        Set<String> set = new LinkedHashSet<>(ref);
        assertEquals(getHomePage().checkHrefSet(set).size(), 0, getHomePage().checkHrefSet(set).toString());
    }

}
