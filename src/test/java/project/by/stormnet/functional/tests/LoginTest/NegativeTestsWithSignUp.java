package project.by.stormnet.functional.tests.LoginTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.ForgotPasswordHelper;
import project.by.stormnet.functional.entities.helpers.HomeHelper;
import project.by.stormnet.functional.entities.helpers.LoginHelper;
import project.by.stormnet.functional.entities.pages.AbstractPage;

@Test(priority = 3)
public class NegativeTestsWithSignUp {

    private HomeHelper homeHelper = new HomeHelper();
    private LoginHelper loginHelper = new LoginHelper();
    private ForgotPasswordHelper passwordHelper = new ForgotPasswordHelper();
    private WebDriver driver = AbstractPage.getDriver();

    private final String PASSWORD = "qwerty123456";
    private String invalidEmail;

    public NegativeTestsWithSignUp(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    @BeforeClass
    public void prepareForTest() {
        AbstractPage.openBrowser();
        homeHelper.openHomePage();
        homeHelper.openLoginPage();
    }

    @Test(priority = 1)
    @Description(value = "Possibility not to login with invalid data")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginWithInvalidData() {
        String expected = "There is 1 error";
        loginHelper.loginWithInvalidData(invalidEmail, PASSWORD);
        String actual = loginHelper.checkInvalidLoginMessage();
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    @Description(value = "Check not send email to recover password, if email not signed up or invalid format")
    @Severity(SeverityLevel.BLOCKER)
    public void checkErrorIfRecoverPasswordWithInvalidEmail() {
        loginHelper.clickForgotPassword();
        passwordHelper.failedPasswordRecovery(invalidEmail);
        boolean result = passwordHelper.checkFailedPasswordRecovery();
        Assert.assertTrue(result, "Message not displayed");
    }

    @AfterClass
    public void tearDown() {
        homeHelper.quit();
    }
}