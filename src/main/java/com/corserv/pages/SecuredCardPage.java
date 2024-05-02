package com.corserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecuredCardPage {

    private WebDriver driver;

    // Locator for the APR for Cash Advances element on the secured card page
    private By aprForCashAdvances = By.xpath("//h5[contains(.,'APR for Cash Advances')]/../div/p/strong");

    public SecuredCardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the APR for Cash Advances from the secured card page
    public double getAprForCashAdvances() {

        // Set up WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the APR for Cash Advances element is visible
        WebElement aprForCashAdvance = wait.until(ExpectedConditions.visibilityOfElementLocated(aprForCashAdvances));

        // Extract the text, parse it to get the APR value as a double
        return Double.parseDouble(aprForCashAdvance.getText().split("%")[0]);
    }
}