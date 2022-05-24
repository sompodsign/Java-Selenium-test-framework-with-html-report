package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HotDealsPage;
import pages.PagesFactory;


public class HotDealsPageTest extends BaseTest {
    HotDealsPage hotDealsPage;

    @Test(priority = 1)
    public void validateHotDealsPageLoadSuccessfully() {
        try {
            initializeTest("HotDealsPage loading test", "This test verifies that the HotDealsPage is loaded successfully", "Sanity Test");

            hotDealsPage = PagesFactory.getHotDealsPage();
            boolean result = hotDealsPage.checkHotDealsPageLoaded();
            Assert.assertTrue(result, "HotDealsPage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}