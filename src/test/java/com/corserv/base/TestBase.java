package com.corserv.base;

import com.corserv.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    // Method to set up the WebDriver before each test method
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    // Method to close the WebDriver after each test method
    @AfterMethod
    public void tearDown() {
        DriverManager.closeDriver();
    }
}