package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification {
    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>(Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login"));
        ArrayList<String> driver = new ArrayList<>(Arrays.asList("chrome", "firefox", "safari"));
        //ArrayList<String> title = new ArrayList<>(Arrays.asList(""));
        for (String each1: driver) {
            int i = 0;
            for(String each2 : urls) {
                TtlVerification(urls.get(i) ,each1 );
                i++;
            }
        }
    }

    public static void TtlVerification (String URL, String browser) {
        WebDriver driver = new BrowserFactory().getDriver(browser);

        // Visit all websites:
        driver.get(URL);

        if (driver.getTitle().equals("Practice")) {
            System.out.println("Pass Title for " + URL + " in " + browser);
        } else
            System.out.println("Fail Title for " + URL + " in " + browser);

        if (driver.getCurrentUrl().contains("http://practice.cybertekschool.com")) {
            System.out.println("PASS URL "  + URL + " in " + browser);
        } else
            System.out.println("FAIL URL " + URL + " in " + browser);

        driver.quit();
    }
}
