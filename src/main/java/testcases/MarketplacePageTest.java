package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MarketplacePage;
import pages.PagesFactory;


public class MarketplacePageTest extends BaseTest {
    MarketplacePage marketplacePage;

    @Test(priority = 1)
    public void validateMarketplacePageLoadSuccessfully() {
        try {
            initializeTest("MarketplacePage loading test", "This test verifies that the MarketplacePage is loaded successfully", "Sanity Test");

            marketplacePage = PagesFactory.getMarketplacePage();
            boolean result = marketplacePage.checkMarketplacePageLoaded();
            Assert.assertTrue(result, "MarketplacePage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2, dependsOnMethods = "validateMarketplacePageLoadSuccessfully")
    public void validateProjectSearchFunctionalityOnMarketPlace() {
        try {
            initializeTest("Project Search functionality test", "This test verifies that the Project Search functionality works", "Sanity Test");

            marketplacePage = PagesFactory.getMarketplacePage();
            boolean result = marketplacePage.checkProjectSearchResult();
            Assert.assertTrue(result, "Project Search functionality is not working");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}