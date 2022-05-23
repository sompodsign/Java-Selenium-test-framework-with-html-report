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

    @FindBy(xpath = "input[type='file'][accept='image/*']")
    WebElement imageUploadInput;

    @FindBy(xpath = "//input[@id='File']")
    WebElement videoUploadInput;

    @FindBy(xpath = "//button[@class='btn btn-post waves-effect waves-light']")
    WebElement postButton;

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
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(sharePostButton);
            step++;
            System.out.println("Step " + step + ": Click on share post button");

            String text = TestData.getRandomWord();
            driverActions.typeText(sharePostTextArea, text);
            step++;
            System.out.println("Step " + step + ": Type text: " + text);

            return driverWaits.waitUntilVisible(20, driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}