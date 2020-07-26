package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.LoginPage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.*;

public class LoginHelper extends AbstractHelper {

    private LoginPage loginPage = new LoginPage();
    private String emailField = "//input[@id='email_create']";
    private String createAccountTitle = "//h1[@class='page-heading'][contains(text(), 'Create an account')]";
    private String yourPersonalInfoTitle = "//h1[@class='page-subheading']";
    private String emailRequiredMessage = "//li[contains(text(), 'An email address required.')]";
    private String passwordRequiredMessage = "//li[contains(text(), 'Password is required.')]";

    public void loginWithValidData(String email, String password) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickSubmitButton();
    }

    public void loginWithEmailOnly(String email) {
        loginPage.inputEmail(email);
        loginPage.clickButtonSubmitError();
        waitForElementVisible(By.xpath(passwordRequiredMessage));
    }

    public void loginWithPasswordOnly(String password) {
        loginPage.inputPassword(password);
        loginPage.clickButtonSubmitError();
        waitForElementVisible(By.xpath(emailRequiredMessage));
    }

    public void loginWithInvalidData(String email, String password) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickButtonSubmitError();
    }

    public String checkInvalidLoginMessage() {
        String result = loginPage.checkInvalidLoginMessage();
        clearLoginField();
        return result;
    }

    public String checkEmailRequiredMessage() {
        return loginPage.checkEmailRequiredMessage();
    }

    public String checkPasswordRequiredMessage() {
        String result = loginPage.checkPasswordRequiredMessage();
        clearLoginField();
        return result;
    }

    private void clearLoginField() {
        loginPage.clearLoginField();
    }

    public void clickForgotPassword() {
        loginPage.clickForgotPassword();
    }

    public void inputRandomEmail(String randomEmail) {
        getElement(emailField).sendKeys(loginPage.generateRandomEmail(randomEmail));
    }

    public void pressBackButton() {
        loginPage.pressBackButton();
    }

    public void inputExistEmail(String email) {
        getElement(emailField).sendKeys(email);
    }

    public void inputInvalidEmail(String invalidEmail) {
        getElement(emailField).sendKeys(invalidEmail);
    }

    public void createAccount() {
        loginPage.clickCreateAccountButton();
        waitForElementVisible(By.xpath(createAccountTitle));
    }

    public void createAccountWithExistEmail() {
        loginPage.clickCreateAccountButtonError();
    }

    public void createAccountWithInvalidEmail() {
        loginPage.clickCreateAccountButtonError();
    }

    public String checkOpeningAuthPage() {
        return loginPage.checkOpeningAuthPage();
    }

    public void openMyInfoDetails() {
        loginPage.clickMyPersonalIInfoBtn();
        waitForElementVisible(By.xpath(yourPersonalInfoTitle));
    }
}