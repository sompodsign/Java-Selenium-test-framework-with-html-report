package pageobjects;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PagesFactory;
import testdata.TestData;

import java.util.List;


public class DashboardPage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Dashboard elements
    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    WebElement dashboardLink;
    // END: Dashboard elements



    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkDashboardPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(dashboardLink);
            step++;
            System.out.println("Step " + step + ": Click on Dashboard link");

            return driver.getCurrentUrl().contains("dashboard");
        }
        catch (Exception e) {
            return false;
        }
    }


}