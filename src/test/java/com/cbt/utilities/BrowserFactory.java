package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    // write a static method that takes a string parameter
    // based on the value of the parameter
    // the method must return chromedriver or firefoxdriver object
    // name: getDriver


    public static WebDriver getDriver(String browserType) {     // Static getDriver method with WebDriver return type
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();        // set driver
            return new ChromeDriver();      // object created
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
            //return driver;
        } else if (browserType.equalsIgnoreCase("safari")) {
            // WebDriver driver (return type & name)
            WebDriverManager.edgedriver().setup();
            return new SafariDriver();

        } else if (browserType.equalsIgnoreCase("edge")) {
            return null;

        } else
            return null;
    }
}
