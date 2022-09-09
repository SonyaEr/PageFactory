package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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
            List<WebElement> subMenu =   getHomePage().getFirstSubMenu(i);
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
        String url;
        HttpURLConnection huc;
        int respCode;

        Iterator<String> it = set.iterator();
        ArrayList<String> invalid = new ArrayList<>();
        while (it.hasNext()) {
            url = it.next();
            if (url == null || url.isEmpty()) {
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    invalid.add(url);
                }
            } catch (IOException e) {
                invalid.add(url);
            }
        }
        assertEquals(invalid.size(), 0, invalid.toString());
    }

}
