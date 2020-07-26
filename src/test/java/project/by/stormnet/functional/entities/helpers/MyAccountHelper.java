package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.MyAccountPage;

public class MyAccountHelper extends AbstractHelper {

    private MyAccountPage myAccountPage = new MyAccountPage();

    public boolean isLoggedIn() {
        boolean result = myAccountPage.checkLogin();
        logOut();
        return result;
    }

    public boolean isAccountCreated() {
        boolean result = myAccountPage.checkLogin();
        logOut();
        return result;
    }

    //    public LoginHelper logOut() {
//        myAccountPage.clickLogoutButton();
//        return new LoginHelper();
//    }
    public void logOut() {
        myAccountPage.clickLogoutButton();
    }
}