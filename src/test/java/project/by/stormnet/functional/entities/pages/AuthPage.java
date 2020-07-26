package project.by.stormnet.functional.entities.pages;

public class AuthPage extends AbstractPage {

    private String emailInput = "//*[@id='login_form']//input[@data-validate='isEmail']";
    private String passwordInput = "//div[@class='form-group']//input[@type='password']";
    private String submitButton = "//button[@id='SubmitLogin']";
    private String errorMessage = "//p[text()='There is 1 error']";


    public void fillEmailInput(String emailAddress) {
        getElement(emailInput).sendKeys(emailAddress);
        scrollPage();
    }

    public void fillPasswordInput(String password) {
        getElement(passwordInput).sendKeys(password);
    }

    public void clickSubmitBtn() {
        getElement(submitButton).click();
    }

    public String checkInvalidLoginMessage() {
        return getElement((errorMessage)).getAttribute("innerText").trim();
    }

    public void clearEmailField() {
        AbstractPage.getElement(emailInput).clear();
    }

    public void clearPasswordField() {
        AbstractPage.getElement(passwordInput).clear();
    }
}