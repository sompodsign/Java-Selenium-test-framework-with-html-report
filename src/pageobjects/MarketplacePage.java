package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PagesFactory;


public class MarketplacePage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: marketplace page elements
    @FindBy(xpath = "//a[contains(text(),'Marketplace')]")
    WebElement dashboardLink;

    @FindBy(xpath = "//h1[normalize-space()='WELCOME TO THE KOMINITI MARKETPLACE']")
    WebElement marketplacePageHeader;

    // END: marketplace page elements


    public MarketplacePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkMarketplacePageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(dashboardLink);
            step++;
            System.out.println("Step " + step + ": Click on Marketplace link");

            return driverWaits.waitUntilVisible(20, marketplacePageHeader);

        } catch (Exception e) {
            return false;
        }
    }


}