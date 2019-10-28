package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class NavigationTests {


    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> browserList = new ArrayList<>(Arrays.asList("chrome", "firefox", "safari"));
        for (String browser : browserList) {
            browserCheck(browser);
            System.out.println("Start testing");
        }
    }

    public static void browserCheck(String browser) throws InterruptedException {

        // open browser
        WebDriver driver = new BrowserFactory().getDriver(browser);
        // go to https://google.com

        driver.get("https://google.com");

        //Save the title in a string variable
        String googletitle = driver.getTitle();        // https://google.com

        //Thread.sleep(3000);


        driver.get("https://etsy.com");
        //driver.quit();

        String etsyTitle = driver.getTitle();            // "https://etsy.com"
        //Thread.sleep(3000);



        // go back to "https://google.com"
        driver.navigate().back();

        StringUtility.verifyEquals(driver.getTitle(), googletitle);
        // navigate forward to "https://etsy.com"
        //Thread.sleep(3000);

        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(), etsyTitle);

        driver.close();

    }

}
