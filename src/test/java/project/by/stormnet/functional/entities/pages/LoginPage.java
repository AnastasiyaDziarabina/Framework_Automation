package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private String loginField = "//input[@id='email']";
    private String passwordField = "//input[@id='passwd']";
    private String buttonSubmit = "//button[@id='SubmitLogin']";
    private String createAccountButton = "//button[@id='SubmitCreate']";
    private String forgotPasswordButton = "//a[@href='http://automationpractice.com/index.php?controller=password']";
    private String messageError = "//p[text()='There is 1 error']";
    private String createAccountMessageError = "//div[@id='create_account_error']/ol/li";
    private String authBreadcrumbs = "//span[@class='navigation_page']";
    private String myAccountTitle = "//h1[@class='page-heading'][contains(text(), 'My account')]";

    private String myPersonalInfoButton = "//span[contains(text(), 'My personal information')]";
    private String yourPersonalInfoTitle = "//h1[@class='page-subheading']";
    private String emailRequiredMessage = "//li[contains(text(), 'An email address required.')]";
    private String passwordRequiredMessage = "//li[contains(text(), 'Password is required.')]";

    public void inputEmail(String email) {
        waitForElementClickable(By.xpath(loginField));
        getElement(loginField).sendKeys(email);
    }

    public String generateRandomEmail(String randomEmail) {
        return (randomEmail + ((int) (Math.random() * 10000) + 1));
    }

    public void clearLoginField() {
        waitForElementClickable(By.xpath(loginField));
        getElement(loginField).clear();
    }

    public void inputPassword(String password) {
        scrollPage();
        waitForElementClickable(By.xpath(passwordField));
        getElement(passwordField).sendKeys(password);
    }

    public void clickSubmitButton() {
        getElement(buttonSubmit).click();
        waitForElementVisible(By.xpath(myAccountTitle));
    }

    public void clickButtonSubmitError() {
        getElement(buttonSubmit).click();
        waitForElementVisible(By.xpath(messageError));
    }

    public void pressBackButton() {
        getDriver().navigate().back();
        getDriver().navigate().refresh();
        waitForElementVisible(By.xpath(myAccountTitle));
    }

    public String checkInvalidLoginMessage() {
        waitForElementVisible(By.xpath(messageError));
        return getElement(messageError).getAttribute("innerText").trim();
    }

    public void clickCreateAccountButtonError() {
        waitForElementVisible(By.xpath(createAccountButton));
        getElement(createAccountButton).click();
        waitForElementVisible(By.xpath(createAccountMessageError));
    }

    public String checkEmailRequiredMessage() {
        waitForElementVisible(By.xpath(emailRequiredMessage));
        return getElement(emailRequiredMessage).getAttribute("innerText").trim();
    }

    public String checkPasswordRequiredMessage() {
        waitForElementVisible(By.xpath(passwordRequiredMessage));
        return getElement(passwordRequiredMessage).getAttribute("innerText").trim();
    }

    public void clickForgotPassword() {
        waitForElementClickable(By.xpath(forgotPasswordButton));
        getElement(forgotPasswordButton).click();
    }

    public void clickCreateAccountButton() {
        waitForElementClickable(By.xpath(createAccountButton));
        getElement(createAccountButton).click();
    }

    public String checkOpeningAuthPage() {
        waitForElementVisible(By.xpath(authBreadcrumbs));
        return getElement(authBreadcrumbs).getAttribute("innerText").trim();
    }

    public void clickMyPersonalIInfoBtn() {
        getElement(myPersonalInfoButton).click();
        waitForElementVisible(By.xpath(yourPersonalInfoTitle));
    }
}