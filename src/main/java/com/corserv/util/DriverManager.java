package com.corserv.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
        // private constructor to prevent instantiation
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    // Method to initialize the WebDriver based on the browser property or default to Chrome
    private static void initializeDriver() {
        
        String browserName = System.getProperty("browser", "chrome"); // Default to Chrome if property not set

        switch (browserName.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:

                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                // start browser maximized
                options.addArguments("--start-maximized"); 

                driver = new ChromeDriver(options);

                break;
        }
    }

    // Method to close the WebDriver instance
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure the old driver is dereferenced
        }
    }
}
