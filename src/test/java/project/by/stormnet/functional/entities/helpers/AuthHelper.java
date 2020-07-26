package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.AuthPage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.scrollPage;

public class AuthHelper extends AbstractHelper {

    private AuthPage authPage = new AuthPage();
    private String addressesTitle = "//h1[@class='page-heading'][contains(text(), 'Addresses')]";

    public void signInWithValidData(String email, String password) {
        scrollPage();
        authPage.clearEmailField();
        authPage.fillEmailInput(email);
        authPage.clearPasswordField();
        authPage.fillPasswordInput(password);
        authPage.clickSubmitBtn();
        AbstractPage.waitForElementVisible(By.xpath(addressesTitle));
    }

    public void signInWithInvalidData(String email, String password) {
        authPage.fillEmailInput(email + ((int) (Math.random() * 500) + 1));
        authPage.fillPasswordInput(password + ((int) (Math.random() * 500) + 1));
        authPage.clickSubmitBtn();
    }

    public boolean isLoggedIn() {
        AbstractPage.waitForElementVisible(By.xpath(addressesTitle));
        return AbstractPage.getElement(addressesTitle).isDisplayed();
    }

    public String checkInvalidLoginMessage() {
        return authPage.checkInvalidLoginMessage();
    }
}