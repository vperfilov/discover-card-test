package com.corserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.corserv.util.*;

public class PreFillPage {

    private WebDriver driver;

    // Locator for the "Skip This Step" button
    private By skipPreFill = By.cssSelector("#adaptive-skip-this-step");

    public PreFillPage(WebDriver driver) {
        this.driver = driver;
    }

    public SecuredCardPage clickOnSkipThisStep() {
        // Set up WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the Skip PreFill button is visible
        WebElement skipPreFillButton = wait.until(ExpectedConditions.visibilityOfElementLocated(skipPreFill));

        // Get the current URL before clicking Skip PreFill
        String currentUrl = driver.getCurrentUrl();

        // Modify the URL by inserting a parameter 'adpt=mn'
        String modifiedUrl = UrlUtils.insertParameter(currentUrl, "adpt", "mn");        
        
        // Click on the Skip PreFill button
        skipPreFillButton.click();

        // Wait until the Skip PreFill button is no longer visible (disappeared)
        wait.until(ExpectedConditions.invisibilityOf(skipPreFillButton));

        // Get the updated current URL after clicking Skip PreFill
        currentUrl = driver.getCurrentUrl();

        // Check if the URL contains "tech_diff"
        if(currentUrl.contains("tech_diff")){
            // If we hit a technical difficulty page, navigate to the modified URL
            driver.get(modifiedUrl);
        }

        // Return a new instance of SecuredCardPage
        return new SecuredCardPage(driver);

    }
}