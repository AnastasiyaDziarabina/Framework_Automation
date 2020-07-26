package project.by.stormnet.functional.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.LoginHelper;
import project.by.stormnet.functional.entities.helpers.CreateAccountHelper;
import project.by.stormnet.functional.entities.helpers.HomeHelper;
import project.by.stormnet.functional.entities.helpers.MyAccountHelper;

@Test(priority = 1)
public class CreateAccountTest {

    private HomeHelper homeHelper = new HomeHelper();
    private LoginHelper loginHelper = new LoginHelper();
    private CreateAccountHelper createHelper = new CreateAccountHelper();
    private MyAccountHelper myAccountHelper = new MyAccountHelper();

    private final String EMAIL = "kate@mailinator.com";
    private String invalidPassword = "123";
    private String randomEmail = "test73465@fscgv.cdo";
    private String invalidEmail = "dff@";

    @BeforeClass
    public void prepareToTest() {
        homeHelper.openHomePage();
    }

    @DataProvider(name = "randomEmailsForSignUpTest")
    public Object[][] validEmailsData() {
        return new Object[][]{{"test16@gmadcil.com"}, {"test7@gmadcil.com"}};
    }

    @DataProvider(name = "randomEmailsForInvalidPassTest")
    public Object[][] validEmails() {
        return new Object[][]{{"test9ca@gdmai.com"}, {"test11@gcdil.com"}};
    }

    @Test(priority = 1, dataProvider = "randomEmailsForSignUpTest")
    @Description(value = "Create account with random valid emails")
    @Severity(SeverityLevel.BLOCKER)
    public void checkPossibilityCreateAccount(String randomEmail) {
        homeHelper.openLoginPage();
        loginHelper.inputRandomEmail(randomEmail);
        loginHelper.createAccount();
        createHelper.fillAllRequiredPersonalInfo();
        boolean isAccountCreated = myAccountHelper.isAccountCreated();
        Assert.assertTrue(isAccountCreated, "Failed!");
    }

    @Test(priority = 2)
    @Description(value = "Impossible to create account with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    public void checkErrorWhenSignUpWithInvalidInfo() {
        homeHelper.openLoginPage();
        loginHelper.inputRandomEmail(randomEmail);
        loginHelper.createAccount();
        createHelper.fillNotAllPersonalInfo();
        boolean result = createHelper.isErrorMessageDisplayedAboutInfo();
        Assert.assertTrue(result);
    }

    @Test(priority = 3, dataProvider = "randomEmailsForInvalidPassTest")
    @Description(value = "Error displayed when logs in with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    public void checkErrorWhenSignUpWithInvalidPassword(String randomEmail) {
        homeHelper.openLoginPage();
        loginHelper.inputRandomEmail(randomEmail);
        loginHelper.createAccount();
        createHelper.createAccountWithInvalidPassword(invalidPassword);
        boolean actual = createHelper.checkErrorPasswordMessage();
        Assert.assertTrue(actual, "Failed!");
    }

    @Test(priority = 4)
    @Description(value = "Error displayed when signs up with exist email")
    @Severity(SeverityLevel.CRITICAL)
    public void checkErrorWhenSignUpWithExistEmail() {
        homeHelper.openLoginPage();
        loginHelper.inputExistEmail(EMAIL);
        loginHelper.createAccountWithExistEmail();
        boolean isErrorDisplayed = createHelper.checkErrorExistEmailMessage();
        Assert.assertTrue(isErrorDisplayed, "Failed!");
    }

    @Test(priority = 5)
    @Description(value = "Error displayed when signs up with invalid email")
    @Severity(SeverityLevel.BLOCKER)
    public void checkErrorWhenSignUpWithInvalidEmail() {
        homeHelper.openLoginPage();
        loginHelper.inputInvalidEmail(invalidEmail);
        loginHelper.createAccountWithInvalidEmail();
        boolean isErrorDisplayed = createHelper.checkInvalidEmailError();
        Assert.assertTrue(isErrorDisplayed, "Failed!");
    }

    @AfterClass
    public void tearDown() {
        homeHelper.quit();
    }
}