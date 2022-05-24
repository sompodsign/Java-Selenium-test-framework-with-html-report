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


}