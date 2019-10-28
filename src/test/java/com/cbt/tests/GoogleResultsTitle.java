package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleResultsTitle {

    public static void main(String[] args) {

        ArrayList<String> searchStrs = new ArrayList<>(Arrays.asList("Java","JUnit","Selenium"));
        ArrayList<String> URL = new ArrayList<>(Arrays.asList("https://www.java.com/en/", "https://junit.org/junit5/", "https://www.seleniumhq.org/"));
        int i = 0;
        for (String search: searchStrs) {
            searchList(search, URL.get(i));
            i++;
        }
    }



    public static void searchList (String srch, String URL ) {

        WebDriver driver = new BrowserFactory().getDriver("chrome");

        // 2. Go to https://google.com

        driver.get("https://google.com");

        // 3. Search for one of the strings the list searchStrs given below
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(srch, Keys.ENTER);
        String expectedUrl = URL;
        WebElement clickfirst = driver.findElement(By.className("LC20lb"));
       clickfirst.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else
            System.out.println("FAIL");


        driver.close();




    }
}
