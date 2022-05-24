package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PagesFactory;


public class HotDealsPage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: marketplace page elements
    @FindBy(xpath = "//li[contains(@class,'menu-item hot-deals')]//a[normalize-space()='Hot Deals']")
    WebElement hotDealsTab;

    @FindBy(xpath = "//h1[normalize-space()='KOMINITI HOT DEALS']")
    WebElement hotDealsPageHeader;

    // END: marketplace page elements


    public HotDealsPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkHotDealsPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(hotDealsTab);
            step++;
            System.out.println("Step " + step + ": Click on Hot Deals link");

            return driverWaits.waitUntilVisible(20, hotDealsPageHeader);

        } catch (Exception e) {
            return false;
        }
    }


}