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

    @FindBy(xpath = "//input[@placeholder='search for projects']")
    WebElement searchField;

    @FindBy(xpath = "//input[@placeholder='Category']")
    WebElement categoryField;

    @FindBy(xpath = "//input[@placeholder='Category']/parent::div/parent::div/following-sibling::div//li")
    WebElement categoryList;

    @FindBy(xpath = "//li[normalize-space()='Web, Mobile & Software Dev']")
    WebElement categoryWebMobileSoftwareDev;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(@value,'1 Projects found')]")
    WebElement projectSearchResult;

    @FindBy(xpath = "//button[normalize-space()='View all categories']")
    WebElement viewAllCategoriesButton;

    @FindBy(xpath = "(//*[contains(text(),'Accounting & Finance')])[3]")
    WebElement accountingFinanceHeader;

    @FindBy(xpath = "//h3[.='Categories']/parent::div/child::div/child::div/child::div")
    WebElement categoriesList;

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

    public boolean checkProjectSearchResult() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(searchField);
            step++;
            System.out.println("Step " + step + ": Click on search field");

            driverActions.typeText(searchField, "Tester");
            step++;
            System.out.println("Step " + step + ": Type 'SQA' in search field");

            driverActions.clickOnWebElementWithActionsClass(categoryField);
            driverActions.clickOnWebElementWithActionsClass(categoryWebMobileSoftwareDev);
            step++;
            System.out.println("Step " + step + ": Click on category field and select 'Web, Mobile & Software Dev'");

            driverActions.clickOnWebElementWithActionsClass(searchButton);
            step++;
            System.out.println("Step " + step + ": Click on search button");

            boolean result = driverWaits.waitUntilVisible(20, projectSearchResult);
            step++;
            System.out.println("Step " + step + ": Wait until project search result is visible");

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

            driverActions.clickOnWebElementWithActionsClass(viewAllCategoriesButton);
            step++;
            System.out.println("Step " + step + ": Click on View all categories button");

            boolean result = driverWaits.waitUntilVisible(20, accountingFinanceHeader);
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