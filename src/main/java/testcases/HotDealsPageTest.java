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

    @Test(priority = 2, dependsOnMethods = {"validateHotDealsPageLoadSuccessfully"})
    public void validateHotDealsSearchFunctionality() {
        try {
            initializeTest("HotDealsPage search functionality test", "This test verifies that the HotDealsPage search functionality is working properly", "Sanity Test");

            hotDealsPage = PagesFactory.getHotDealsPage();
            boolean result = hotDealsPage.checkHotDealsSearchResult();
            Assert.assertTrue(result, "HotDealsPage search functionality is not working properly");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 3, dependsOnMethods = "validateHotDealsPageLoadSuccessfully")
    public void validateViewAllCategoriesButtonFunctionality() {

        try {
            initializeTest("View All Categories button functionality test", "This test verifies that the View All Categories button functionality works", "Sanity Test");

            hotDealsPage = PagesFactory.getHotDealsPage();
            boolean result = hotDealsPage.checkViewAllCategoriesButtonFunctionality();

            Assert.assertTrue(result, "View All Categories button functionality is not working");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}