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

    @FindBy(xpath = "//input[@placeholder='Search Hot Deals']")
    WebElement searchHotDealsInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchHotDealsButton;

    @FindBy(xpath = "//div[@class='searchlist__result']//p[1]")
    WebElement searchResult;

    @FindBy(xpath = "//a[normalize-space()='View all categories']")
    WebElement viewAllCategoriesLink;

    @FindBy(xpath = "//div[normalize-space()='Categories']")
    WebElement categoriesHeader;

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

    public boolean checkHotDealsSearchResult() {
        try {
            int step = 0;

            driverActions.typeText(searchHotDealsInput, "Kominiti");
            step++;
            System.out.println("Step " + step + ": Type text into search input");

            driverActions.clickOnWebElementWithActionsClass(searchHotDealsButton);
            step++;
            System.out.println("Step " + step + ": Click on search button");

            boolean result = driverWaits.waitUntilVisible(20, searchResult);

            driverActions.browserBack();
            step++;
            System.out.println("Step " + step + ": Browser back");

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkViewAllCategoriesButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(viewAllCategoriesLink);
            step++;
            System.out.println("Step " + step + ": Click on View all categories button");

            boolean result = driverWaits.waitUntilVisible(20, categoriesHeader);
            step++;
            System.out.println("Step " + step + ": Wait until category list is visible");

            driverActions.browserBack();
            step++;
            System.out.println("Step " + step + ": Browser back");

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}