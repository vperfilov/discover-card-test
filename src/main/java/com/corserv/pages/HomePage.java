package com.corserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.corserv.config.ConfigLoader;

public class HomePage {
    private WebDriver driver;

    // Locator for the credit cards icon on the homepage
    private By creditCardsIcon = By.cssSelector(".slide--img.credit-card");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the home page using the baseURL from config.properties
    public void navigateToHomePage() {
        ConfigLoader config = new ConfigLoader("./src/main/resources/config.properties");
        driver.get(config.getProperty("baseURL"));

    }

    // Method to click on the credit cards icon and navigate to the CreditCardsPage
    public CreditCardsPage clickOnCreditCards() {

        // Set up WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the credit cards icon is visible
        WebElement creditCardsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardsIcon));
        
        // Click on the credit cards icon
        creditCardsElement.click();

        // Return a new instance of CreditCardsPage
        return new CreditCardsPage(driver);
    }

}