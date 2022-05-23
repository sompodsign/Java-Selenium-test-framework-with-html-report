package main.java.testcases;

import DataModel.TestDataModel;
import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pages.PagesFactory;


@SuppressWarnings("ThrowablePrintedToSystemOut")
public class HomepageTest extends BaseTest {
    @SuppressWarnings("unused")
    HomePage homePage;

    @Test(priority = 1)
    public void validateHomePageLoadSuccessfully() {
        try {
            initializeTest("Homepage loading test", "This test verifies that the homepage is loaded successfully", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.checkHomePageLoaded();
            Assert.assertTrue(result, "Homepage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateUserCanShareTextOnTimeline() {
        try {
            initializeTest("User can share text on timeline", "This test verifies that the user can share text on timeline", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareTextOnTimeline();

            Assert.assertTrue(result, "Text is not shared on timeline");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}