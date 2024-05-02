package com.corserv.tests;

import com.corserv.base.TestBase;
import com.corserv.pages.HomePage;
import com.corserv.pages.CreditCardsPage;
import com.corserv.pages.PreFillPage;
import com.corserv.pages.SecuredCardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditCardApplicationTest extends TestBase {

    @Test
    public void testSecuredCardApplication() {
        // Navigate to the homepage
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Navigate to the Credit Cards page
        CreditCardsPage creditCardsPage = homePage.clickOnCreditCards();

        // Skip the pre-fill step
        PreFillPage preFillPage = creditCardsPage.clickOnSecuredCardApply();

        // Navigate to the Secured Credit Card application page
        SecuredCardPage securedCardPage = preFillPage.clickOnSkipThisStep();

        // Assert that the APR for Cash Advances is greater than 20%
        double aprForCashAdvances = securedCardPage.getAprForCashAdvances();
        Assert.assertTrue(aprForCashAdvances > 20.0, "APR for Cash Advances should be greater than 20%");
    }
}