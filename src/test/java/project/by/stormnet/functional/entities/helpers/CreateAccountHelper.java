package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.CreateAccountPage;

public class CreateAccountHelper extends AbstractHelper {

    private CreateAccountPage createAccountPage = new CreateAccountPage();

    public void fillAllRequiredPersonalInfo() {
        createAccountPage.clickGenderButton();
        createAccountPage.inputFirstName();
        createAccountPage.inputLastName();
        createAccountPage.inputPassword();
        createAccountPage.inputAddress();
        createAccountPage.inputCity();
        createAccountPage.clickStateBtn();
        createAccountPage.inputPostCode();
        createAccountPage.inputPhoneNumber();
        createAccountPage.inputMyAddress();
        createAccountPage.clickRegisterBtn();
    }

    public void fillNotAllPersonalInfo() {
        createAccountPage.clickGenderButton();
        createAccountPage.inputFirstName();
        createAccountPage.inputLastName();
        createAccountPage.inputPassword();
        createAccountPage.inputPhoneNumber();
        createAccountPage.inputAddress();
        createAccountPage.clickRegisterBtnError();
    }

    public void createAccountWithInvalidPassword(String password) {
        createAccountPage.clickGenderButton();
        createAccountPage.inputFirstName();
        createAccountPage.inputLastName();
        createAccountPage.inputInvalidPassword(password);
        createAccountPage.inputAddress();
        createAccountPage.inputCity();
        createAccountPage.clickStateBtn();
        createAccountPage.inputPostCode();
        createAccountPage.inputPhoneNumber();
        createAccountPage.inputMyAddress();
        createAccountPage.clickRegisterBtnError();
    }

    public boolean isErrorMessageDisplayedAboutInfo() {
        boolean result = createAccountPage.checkErrorInfoMessage();
        createAccountPage.clickHomeButton();
        return result;
    }

    public boolean checkErrorPasswordMessage() {
        boolean result = createAccountPage.checkErrorPasswordMessageText();
        createAccountPage.clickHomeButton();
        return result;
    }

    public boolean checkErrorExistEmailMessage() {
        boolean result = createAccountPage.checkErrorSignUpMessage();
        createAccountPage.clickHomeButton();
        return result;
    }

    public boolean checkInvalidEmailError() {
        boolean result = createAccountPage.checkErrorInvalidEmail();
        createAccountPage.clickHomeButton();
        return result;
    }
}