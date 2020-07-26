package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.YourPersonalInfoPage;

public class YourPersonalInfoHelper extends AbstractHelper {

    private YourPersonalInfoPage personalInfoPage = new YourPersonalInfoPage();
    private MyAccountHelper myAccountHelper = new MyAccountHelper();
    String firstName;
    String lastName;

    public boolean isCorrectUserInfoDisplayed() {
        firstName = personalInfoPage.getFirstName();
        lastName = personalInfoPage.getLastName();
        String names = personalInfoPage.getNamesFromHeader();
        myAccountHelper.logOut();
        return names.contains(firstName) && names.contains(lastName);
    }
}