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

    @Test
    public void validateUserCanShareTextOnTimelineWithImage() {
        try {
            initializeTest("User can share text on timeline with image", "This test verifies that the user can share text on timeline with image", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareTextOnTimelineWithImage();

            Assert.assertTrue(result, "Text is not shared on timeline with image");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateUserCanShareVideosOnTimeline() {
        try {
            initializeTest("User can share videos on timeline", "This test verifies that the user can share videos on timeline", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.shareVideoOnTimeline();

            Assert.assertTrue(result, "Video is not shared on timeline");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateUserCanWriteArticleAndShare() {
        try {
            initializeTest("User can write article and share", "This test verifies that the user can write article and share", "Sanity Test");

            HomePage homepage = PagesFactory.getHomePage();
            boolean result = homepage.writeArticleAndShare();

            Assert.assertTrue(result, "Article is not shared on timeline");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}