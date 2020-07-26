package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends AbstractPage {

    private static String myAccountTitle = "//h1[@class='page-heading'][contains(text(), 'My account')]";
    private String logoutButton = "//a[@class='logout']";
    private String authTitle = "//h1[@class='page-heading'][contains(text(), 'Authentication')]";

    public void clickLogoutButton() {
        waitForElementVisible(By.xpath(logoutButton));
        getElement(logoutButton).click();
        waitForElementVisible(By.xpath(authTitle));
    }

    public boolean checkLogin() {
        return getElement(myAccountTitle).isDisplayed();
    }
}