package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.ForgotPasswordPage;

public class ForgotPasswordHelper extends AbstractHelper {

    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private String forgotPasswordButton = "//a[@href='http://automationpractice.com/index.php?controller=password']";

    public void inputEmailToRecoverPassword(String email) {
        forgotPasswordPage.inputEmail(email);
        forgotPasswordPage.clickRetrievePasswordButton();
    }

    public void failedPasswordRecovery(String email) {
        forgotPasswordPage.inputEmail(email);
        forgotPasswordPage.clickRetrievePasswordButtonError();
    }

    public boolean isSendToEmailMessageDisplayed() {
        boolean result = forgotPasswordPage.checkSuccessMessage();
        clickBackToLoginButton();
        return result;
    }

    public boolean checkFailedPasswordRecovery() {
        boolean result = forgotPasswordPage.checkErrorMessage();
        clickBackToLoginButton();
        return result;
    }

    public void clickBackToLoginButton() {
        forgotPasswordPage.clickBackToLoginButton();
        AbstractPage.waitForElementClickable(By.xpath(forgotPasswordButton));
    }
}