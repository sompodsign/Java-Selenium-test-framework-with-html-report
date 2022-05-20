package main.java.testcases;

import DataModel.TestDataModel;
import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pages.PagesFactory;

import applicationsettings.ApplicationSettings;


@SuppressWarnings("ThrowablePrintedToSystemOut")
public class LoginPageTest extends BaseTest {
    @SuppressWarnings("unused")
    LoginPage loginPage;
    //String email = ApplicationSettings.getAliasEmailAddress("unidevgo.qa");


    @Test(dataProvider = "credentials", dataProviderClass = TestDataProvider.class,priority = 1)
    public void validateSignUpFunctionality(String name, String email, String password) {

        try {

            initializeTest("Validate signup Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();
            TestDataModel testData = new TestDataModel();

            testData.setEmail(email);
            System.out.println(email);
            testData.setPassword(password);
            testData.setName(name);


            System.out.println("\nStarting signup into the site.\\n");
            boolean signupResult = loginPage.signup(testData);
//            Assert.assertTrue(loginResult, "Login failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    @Test(dataProvider = "credentials", dataProviderClass = TestDataProvider.class,priority = 2)
    public void validateLoginFunctionality(String email, String password) {

        try {

            initializeTest("Validate Login Functionality", "This test will verify that user is able to login to the application with valid credential", "Sanity Test");

            loginPage = PagesFactory.getLoginPage();
            TestDataModel testData = new TestDataModel();

            testData.setEmail(email);
            testData.setPassword(password);


            System.out.println("\nStarting login into the site.\\n");
            boolean loginResult = loginPage.login(testData);
            //Assert.assertTrue(loginResult, "Login failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
}