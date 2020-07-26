package project.by.stormnet.functional.tests.LoginTest;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.*;
import project.by.stormnet.functional.entities.pages.AbstractPage;

@Test(priority = 2)
public class LoginTest {

    private HomeHelper homeHelper = new HomeHelper();
    private LoginHelper loginHelper = new LoginHelper();
    private MyAccountHelper myAccountHelper = new MyAccountHelper();
    private ForgotPasswordHelper passwordHelper = new ForgotPasswordHelper();
    private YourPersonalInfoHelper personalInfoHelper = new YourPersonalInfoHelper();

    private final String EMAIL = "kate@mailinator.com";
    private final String PASSWORD = "qwerty123456";

    @BeforeClass
    public void prepareToTest() {
        AbstractPage.openBrowser();
        homeHelper.openHomePage();
        homeHelper.openLoginPage();
    }

    @Test(priority = 1)
    @Description(value = "Log in with invalid login&password")
    @Severity(SeverityLevel.CRITICAL)
    public void checkLoginWithValidData() {
        loginHelper.loginWithValidData(EMAIL, PASSWORD);
        boolean actual = myAccountHelper.isLoggedIn();
        Assert.assertTrue(actual, "Invalid login or password");
    }

    @Test(priority = 2)
    @Description(value = "Log in from footer")
    @Severity(SeverityLevel.MINOR)
    public void checkPossibilityToLoginFromFooter() {
        homeHelper.openAuthPageFromHeader();
        loginHelper.loginWithValidData(EMAIL, PASSWORD);
        boolean actual = myAccountHelper.isLoggedIn();
        Assert.assertTrue(actual, "Invalid login or password");
    }

    @Test(priority = 3)
    @Description(value = "Check possibility to recover password")
    @Severity(SeverityLevel.CRITICAL)
    public void checkForgotPasswordFunction() {
        loginHelper.clickForgotPassword();
        passwordHelper.inputEmailToRecoverPassword(EMAIL);
        boolean result = passwordHelper.isSendToEmailMessageDisplayed();
        Assert.assertTrue(result, "Message not displayed");
    }

    @Test(priority = 4)
    @Description(value = "Check opening auth page after log in")
    @Severity(SeverityLevel.MINOR)
    public void checkOpeningAuthPage() {
        String expected = "Authentication";
        loginHelper.clickForgotPassword();
        passwordHelper.clickBackToLoginButton();
        String actual = loginHelper.checkOpeningAuthPage();
        Assert.assertEquals(actual, expected, "Failed back to login!");
    }

    @Test(priority = 5)
    @Description(value = "Check if user still logged in when pressing back from login page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkPressingBackNotLoggedOut() {
        loginHelper.loginWithValidData(EMAIL, PASSWORD);
        loginHelper.pressBackButton();
        boolean actual = myAccountHelper.isLoggedIn();
        Assert.assertTrue(actual, "Invalid login or password");
    }

    @Test(priority = 6)
    @Description(value = "Check name is displayed in header, after logs in")
    @Severity(SeverityLevel.NORMAL)
    public void checkNameDisplayedInHeaderWhenLoggedIn() {
        loginHelper.loginWithValidData(EMAIL, PASSWORD);
        loginHelper.openMyInfoDetails();
        boolean isCorrespondName = personalInfoHelper.isCorrectUserInfoDisplayed();
        Assert.assertTrue(isCorrespondName, "First&Last Names do nor correspond from header with userInfo.");
    }

    @Test(priority = 7)
    @Description(value = "Required password field, when logs in")
    @Severity(SeverityLevel.BLOCKER)
    public void checkPasswordIsRequiredWhenLogIn() {
        String expected = "Password is required.";
        loginHelper.loginWithEmailOnly(EMAIL);
        String actual = loginHelper.checkPasswordRequiredMessage();
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 8)
    @Description(value = "Required email field, when logs in.")
    @Severity(SeverityLevel.BLOCKER)
    public void checkEmailIsRequiredWhenLogIn() {
        String expected = "An email address required.";
        loginHelper.loginWithPasswordOnly(PASSWORD);
        String actual = loginHelper.checkEmailRequiredMessage();
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        homeHelper.quit();
    }
}