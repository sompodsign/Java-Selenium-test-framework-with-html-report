package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import pages.PagesFactory;

import DataModel.TestDataModel;
import testdata.TestData;


public class HomePage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Homepage elements
    @FindBy(xpath = "//div[@class='form-control share-post']")
    WebElement sharePostButton;

    @FindBy(xpath = "//textarea[@placeholder='Share what is on your mind...']")
    WebElement sharePostTextArea;

    @FindBy(xpath = "//span[normalize-space()='Images']/following-sibling::input")
    WebElement imageUploadInput;

    @FindBy(xpath = "//input[@id='File']")
    WebElement videoUploadInput;

    @FindBy(xpath = "//button[@class='btn btn-post waves-effect waves-light']")
    WebElement postButton;

    @FindBy(xpath = "//div[@class='media-uploaded']")
    List<WebElement> uploadedImages;

    @FindBy(xpath = "//span[normalize-space()='a few seconds ago']")
    WebElement aFewSecondsAgo;

    @FindBy(xpath = "//span[normalize-space()='Write an article']")
    WebElement writeArticleButton;

    @FindBy(xpath = "//span[contains(text(), \"Change cover\")]/following-sibling::input")
    WebElement articleCover;

    @FindBy(xpath = "//textarea[@id='headline']")
    WebElement articleHeadline;

    @FindBy(xpath = "//div[@aria-label='write here..']")
    WebElement writeArticleTextArea;

    @FindBy(xpath = "//input[@placeholder='Paste the links here and press Enter to Add']")
    WebElement pasteLinkInput;

    @FindBy(xpath = "//span[@class='btn btn-round-link btn-icon-file']//input[@type='file']")
    WebElement articleImageUploadField;

    @FindBy(xpath = "//span[@class='btn btn-round-link btn-icon-file btn-video-attchment']//input[@type='file']")
    WebElement articleVideoUploadField;

    @FindBy(xpath = "//span[normalize-space()='Publish']")
    WebElement publishButton;

    @FindBy(xpath = "//*[contains(text(), \"Article published successfully\")]")
    WebElement articlePublishedSuccessfullyMessage;

    // END: Homepage elements



    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkHomePageLoaded() {
        try {
            System.out.println("Checking Home Page loaded");
            return driverWaits.waitUntilVisible(10, sharePostButton);
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean shareTextOnTimeline() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

            String text = TestData.getRandomWord();
            driverActions.typeText(sharePostTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text: " + text);

            return driverWaits.isElementVisibleWithText(20, text);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean shareTextOnTimelineWithImage() {
        try {

            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

//            driverWaits.waitOneSeconds();
            String text = TestData.getRandomWord();
            driverActions.clickOnWebElementWithActionsClass(sharePostTextArea);
            driverActions.typeText(sharePostTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text: " + text);

            driverActions.uploadImage(imageUploadInput, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");
            driverWaits.waitFiveSeconds();

            driverActions.clickOnWebElementWithActionsClass(postButton);
            step++;
            System.out.println("Step " + step + ": Click on post button");

            return driverWaits.waitUntilVisible(30, (WebElement) By.xpath("//*[normalize-space()='" + text + "']"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean shareVideoOnTimeline() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

            driverActions.upload(videoUploadInput, ApplicationSettings.getVideoFolderPath(), TestData.getRandomVideo());
            step++;
            System.out.println("Step " + step + ": Upload video");
            driverWaits.waitFiveSeconds();

            driverActions.clickOnWebElementWithActionsClass(postButton);
            step++;
            System.out.println("Step " + step + ": Click on post button");

            return driverWaits.waitUntilVisible(25, aFewSecondsAgo);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean writeArticleAndShare() {
        try {
            int step;
            step = 0;

            driverActions.clickOnWebElementWithActionsClass(writeArticleButton);
            step++;
            System.out.println("Step " + step + ": Click on write article button");

            driverWaits.waitUntilVisible(10, articleCover);
            driverActions.uploadImage(articleCover, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");

            driverActions.typeText(articleHeadline, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type text: headline");

            driverActions.typeText(writeArticleTextArea, TestData.getRandomParagraph());
            step++;
            System.out.println("Step " + step + ": Type text: text");

            driverActions.uploadImage(articleImageUploadField, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload image");

            driverActions.upload(articleVideoUploadField, ApplicationSettings.getVideoFolderPath(), TestData.getRandomVideo());
            step++;
            System.out.println("Step " + step + ": Upload video");

            driverActions.clickOnWebElementWithActionsClass(publishButton);
            step++;
            System.out.println("Step " + step + ": Click on publish button");

            return driverWaits.waitUntilVisible(30, articlePublishedSuccessfullyMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}