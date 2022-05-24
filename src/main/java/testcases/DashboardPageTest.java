package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pages.PagesFactory;


public class DashboardPageTest extends BaseTest {
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void validateDashboardPageLoadSuccessfully() {
        try {
            initializeTest("DashboardPage loading test", "This test verifies that the DashboardPage is loaded successfully", "Sanity Test");

            dashboardPage = PagesFactory.getDashboardPage();
            boolean result = dashboardPage.checkDashboardPageLoaded();
            Assert.assertTrue(result, "DashboardPage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}