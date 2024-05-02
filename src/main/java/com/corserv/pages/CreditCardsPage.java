package com.corserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditCardsPage {

    private WebDriver driver;

    // Locator for the "Apply Now" button for secured credit cards
    private By securedCreditCardApplyButton = By
            .xpath("//a[contains(@class, 'cmp-button') and @data-analytics-label='SECURED_APPLY_NOW']");

    public CreditCardsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click on the "Apply Now" button for secured credit cards
    public PreFillPage clickOnSecuredCardApply() {
        // Set up WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the "Apply Now" button for secured credit cards is visible
        WebElement securedCardApply = wait
                .until(ExpectedConditions.visibilityOfElementLocated(securedCreditCardApplyButton));

        // Click on the "Apply Now" button for secured credit cards        
        securedCardApply.click();

        // Return a new instance of PreFillPage
        return new PreFillPage(driver);

    }
}