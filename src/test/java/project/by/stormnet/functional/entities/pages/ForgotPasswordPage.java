package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class ForgotPasswordPage extends AbstractPage {

    private String emailField = "//input[@id='email']";
    private String retrievePasswordButton = "//button[@class='btn btn-default button button-medium']";
    private String backToLoginButton = "//span/i[@class='icon-chevron-left']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String errorMessage = "//div[@class='alert alert-danger']";

    public void inputEmail(String email) {
        waitForElementClickable(By.xpath(emailField));
        getElement(emailField).sendKeys(email);
    }

    public void clickRetrievePasswordButton() {
        scrollPage();
        getElement(retrievePasswordButton).click();
    }

    public void clickRetrievePasswordButtonError() {
        getElement(retrievePasswordButton).click();
        waitForElementVisible(By.xpath(errorMessage));
    }

    public boolean checkSuccessMessage() {
        waitForElementVisible(getElementBy(successMessage));
        return getElement(successMessage).isDisplayed();
    }

    public boolean checkErrorMessage() {
        waitForElementVisible(getElementBy(errorMessage));
        return getElement(errorMessage).isDisplayed();
    }

    public void clickBackToLoginButton() {
        waitForElementVisible(By.xpath(backToLoginButton));
        getElement(backToLoginButton).click();
    }
}