package pageobjects;

import java.util.List;
import java.util.Objects;

import DataModel.TestDataModel;
import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.testng.Assert;
import pages.PagesFactory;

import testdata.TestData;


public class LoginPage extends Base {

    // Declared the private driver of behavior tab on a specific story page
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // Start: Signup elements
    @FindBy(xpath = "//button[normalize-space()='Sign Up']")
    WebElement signUpButton;

    @FindBy(xpath = "//h4[normalize-space()='Individual']")
    WebElement individualButton;

    @FindBy(xpath = "//h4[normalize-space()='Business Owner']")
    WebElement businessOwnerButton;

    @FindBy(xpath = "//h4[normalize-space()='Job Seeker']")
    WebElement jobSeekerButton;

    @FindBy(xpath = "//h4[normalize-space()='Freelancer']")
    WebElement freelancerButton;

    @FindBy(xpath = "//h4[normalize-space()='Others']")
    WebElement othersButton;

    @FindBy(xpath = "//h3[normalize-space()='Sign Up to Kominiti']")
    WebElement signUpToKominitiHeader;

    @FindBy(xpath = "//span[normalize-space()='Name surname:']/following-sibling::div/child::input")
    WebElement nameInputField;

    @FindBy(xpath = "//span[normalize-space()='Email:']/following-sibling::div/child::input")
    WebElement emailInputField;

    @FindBy(xpath = "//span[normalize-space()='Password:']/following-sibling::div/child::input")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@name='isAcceptTerm']")
    WebElement acceptTermsCheckBox;

    @FindBy(xpath = "//button[normalize-space()='Get Started']")
    WebElement getStartedButton;

    @FindBy(xpath = "//div[@class='type_account--text']")
    WebElement accountTypeText;

    @FindBy(xpath = "//h3[normalize-space()='Verify Your Email']")
    WebElement verifyEmailHeader;

    @FindBy(xpath = "//*[contains(text(), \"Email Resent Successfully\")]")
    WebElement emailResentSuccessfully;

    @FindBy(xpath = "//button[normalize-space()='Resend email']")
    WebElement resendEmailButton;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//h4[normalize-space()='Sign up your business']")
    WebElement signUpYourBusinessHeader;

    @FindBy(xpath = "//span[normalize-space()='Name:']/following-sibling::div/child::input")
    WebElement businessNameInputField;

    @FindBy(xpath = "//span[normalize-space()='Website:']/following-sibling::div/child::input")
    WebElement businessWebsiteInputField;

    @FindBy(xpath = "//*[@placeholder='Industry']")
    WebElement businessIndustryInputField;

    @FindBy(xpath = "//li[@class='custom-drop-down-item']")
    List<WebElement> dropDownList;

    @FindBy(xpath = "//input[contains(@placeholder,'Sub Industry')]")
    WebElement businessSubIndustryInputField;

    @FindBy(xpath = "//input[contains(@placeholder,'Select Company Size')]")
    WebElement businessCompanySizeInputField;

    @FindBy(xpath = "//input[contains(@placeholder,'Service name')]")
    WebElement titleField;

    @FindBy(xpath = "//button[@class='add-media']//input[@name='file']")
    WebElement uploadFileButton;

    @FindBy(xpath = "(//textarea)[2]")
    WebElement descriptionField;

    @FindBy(xpath = "//button[normalize-space()='Add Service']")
    WebElement addServiceButton;

    @FindBy(xpath = "//div[@class='mask-label']//input[@name='file']")
    WebElement logoInputField;

    @FindBy(xpath = "//input[@name='accountTypes']")
    WebElement accountTypeInputField;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//h4[normalize-space()='Business Owner']")
    WebElement businessOwnerHeader;

    @FindBy(xpath = "(//textarea)[4]")
    WebElement tagLineField;

    // END: Signup elements

    // START: Login elements
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@placeholder=\"email@example.com\"]")
    WebElement emailInputFieldLogin;

    @FindBy(xpath = "//*[contains(text(),'Password:')]/parent::div/child::div//input")
    WebElement passwordInputFieldLogin;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButtonLogin;

    @FindBy(xpath = "//button[normalize-space()='Forgot Password']")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButtonLogin;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButtonLogin2;

    @FindBy(xpath = "//button[normalize-space()='Forgot Password']")
    WebElement forgotPasswordButton2;

    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement resetPasswordButton2;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton2;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButtonLogin2;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButtonLogin3;

    @FindBy(xpath = "//button[normalize-space()='Forgot Password']")
    WebElement forgotPasswordButton3;

    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement resetPasswordButton3;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton3;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButtonLogin3;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButtonLogin4;

    // END: Login elements

    // START: Homepage elements
    @FindBy(xpath = "//div[@class='form-control share-post']")
    WebElement sharePostButton;
    // END: Homepage elements




    // Initializing the driver for behavior tab on a specific story page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }


    public boolean signupAsIndividual(String accountType) {
        try {

            int step = 0;

            driver.get(ApplicationSettings.getUrl());
            driverActions.clickOnWebElementWithActionsClass(signUpButton);
            step++;
            System.out.println("Step " + step + ": Click on Sign Up button");

            driverActions.clickOnWebElementWithActionsClass(individualButton);
            step++;
            System.out.println("Step " + step + ": Click on Individual button");

            if (Objects.equals(accountType, "job seeker")) {
                driverActions.clickOnWebElementWithActionsClass(jobSeekerButton);
                step++;
                System.out.println("Step " + step + ": Click on Job Seeker button");
            }
            else if (Objects.equals(accountType, "freelancer")) {
                driverActions.clickOnWebElementWithActionsClass(freelancerButton);
                step++;
                System.out.println("Step " + step + ": Click on Freelancer button");
            }
            else if (Objects.equals(accountType, "others")) {
                driverActions.clickOnWebElementWithActionsClass(othersButton);
                step++;
                System.out.println("Step " + step + ": Click on Others button");
            }

            driverActions.typeText(nameInputField, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type random full name");

            driverActions.typeText(emailInputField, TestData.getRandomEmail());
            step++;
            System.out.println("Step " + step + ": Type random email");

            driverActions.typeText(passwordInputField, TestData.generateStrongPassword(10));
            step++;
            System.out.println("Step " + step + ": Type random password");

            driverActions.clickOnWebElementUsingJavaScript(acceptTermsCheckBox);
            step++;
            System.out.println("Step " + step + ": Click on Accept Terms checkbox");

            driverActions.clickOnWebElementWithActionsClass(getStartedButton);
            step++;
            System.out.println("Step " + step + ": Click on Get Started button");

            driverActions.clickOnWebElementWithActionsClass(resendEmailButton);
            step++;
            System.out.println("Step " + step + ": Click on Resend email button");
            Assert.assertTrue(driverWaits.waitUntilVisible(10, emailResentSuccessfully));

            return driverWaits.waitUntilVisible(20, verifyEmailHeader);


        } catch (Exception ex) {
            System.out.println(ex);

            return false;
        }
    }

    public boolean businessSignup(){
        try {
            int step = 0;

            driver.get(ApplicationSettings.getUrl());
            driverActions.clickOnWebElementWithActionsClass(signUpButton);
            step++;
            System.out.println("Step " + step + ": Click on Sign Up button");

            driverActions.clickOnWebElementWithActionsClass(businessOwnerButton);
            step++;
            System.out.println("Step " + step + ": Click on Business Owner button");
            Assert.assertTrue(driverWaits.waitUntilVisible(10, businessOwnerHeader));

            driverActions.typeText(nameInputField, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type random full name");

            driverActions.typeText(emailInputField, TestData.getRandomEmail());
            step++;
            System.out.println("Step " + step + ": Type random email");

            driverActions.typeText(passwordInputField, TestData.generateStrongPassword(10));
            step++;
            System.out.println("Step " + step + ": Type random password");

            driverActions.clickOnWebElementUsingJavaScript(acceptTermsCheckBox);
            step++;
            System.out.println("Step " + step + ": Click on Accept Terms checkbox");

            driverActions.clickOnWebElementWithActionsClass(nextButton);
            step++;
            System.out.println("Step " + step + ": Click on Next button");
            Assert.assertTrue(driverWaits.waitUntilVisible(10, signUpYourBusinessHeader));

            driverActions.typeText(businessNameInputField, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type random full name");

            driverActions.typeText(businessWebsiteInputField, TestData.getRandomWebsite());
            step++;
            System.out.println("Step " + step + ": Type random website");

            driverActions.clickOnWebElementWithActionsClass(businessIndustryInputField);
            step++;
            System.out.println("Step " + step + ": Click on Business Industry input field");

            driverActions.clickOnWebElementWithActionsClass(dropDownList.get(RandomUtils.nextInt(dropDownList.size())));
            step++;
            System.out.println("Step " + step + ": Click on random industry");

            driverActions.clickOnWebElementWithActionsClass(businessSubIndustryInputField);
            step++;
            System.out.println("Step " + step + ": Click on Business Sub Industry input field");

            driverActions.clickOnWebElementWithActionsClass(dropDownList.get(RandomUtils.nextInt(dropDownList.size())));
            step++;
            System.out.println("Step " + step + ": Click on random sub industry");

            driverActions.clickOnWebElementWithActionsClass(businessCompanySizeInputField);
            step++;
            System.out.println("Step " + step + ": Click on Business Company Size input field");

            driverActions.clickOnWebElementWithActionsClass(dropDownList.get(RandomUtils.nextInt(dropDownList.size())));
            step++;
            System.out.println("Step " + step + ": Click on random company size");

            driverActions.typeText(titleField, TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Type service name");

            driverActions.uploadImage(uploadFileButton, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload random image");

            driverActions.typeText(descriptionField, TestData.getRandomParagraph());
            step++;
            System.out.println("Step " + step + ": Type random description");

            driverActions.uploadImage(logoInputField, TestData.getRandomImage());
            step++;
            System.out.println("Step " + step + ": Upload random image");

            driverActions.typeText(tagLineField, TestData.getRandomParagraph());
            step++;
            System.out.println("Step " + step + ": Type random tag line");

            driverActions.clickOnWebElementWithActionsClass(nextButton);
            step++;
            System.out.println("Step " + step + ": Click on Next button");

            driverActions.clickOnWebElementUsingJavaScript(accountTypeInputField);
            step++;
            System.out.println("Step " + step + ": Click on Account Type input field");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20,verifyEmailHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean login(TestDataModel loginData) {

        String email = loginData.getEmail();
        String password = loginData.getPassword();
        System.out.println(email+"loginPage");
        try {

            int step = 0;

            driver.get(ApplicationSettings.getUrl());
            driverActions.clickOnWebElementWithActionsClass(signInButton);
            step++;
            System.out.println("Step " + step + ": Click on Sign In button");

            driverActions.typeText(emailInputField, email);
            step++;
            System.out.println("Step " + step + ": Type email");

            driverActions.typeText(passwordInputField, password);
            step++;
            System.out.println("Step " + step + ": Type password");

            driverActions.clickOnWebElementWithActionsClass(signInButton);
            step++;
            System.out.println("Step " + step + ": Click on Login button");

            return driverWaits.waitUntilVisible(30,sharePostButton);
        }
        catch (Exception ex) {
            System.out.println(ex + "\n");
            return false;
        }
    }
}