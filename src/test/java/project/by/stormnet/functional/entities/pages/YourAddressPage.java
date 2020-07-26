package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class YourAddressPage extends AbstractPage {

    private String addressField = "//*[@id='address1']";
    private String postCodeField = "//input[@name='postcode']";

    private String saveButton = "//button[@type='submit'][@name='submitAddress']";

    public void clearAddressField() {
        waitForElementClickable(By.xpath(addressField));
        AbstractPage.getElement(addressField).clear();
    }

    public void inputNewAddress(String address) {
        waitForElementClickable(By.xpath(addressField));
        AbstractPage.getElement(addressField).sendKeys(address);
    }

    public void clearPostCodeField() {
        AbstractPage.getElement(postCodeField).clear();
    }

    public void inputNewPostCode(String postCode) {
        waitForElementClickable(By.xpath(postCodeField));
        AbstractPage.getElement(postCodeField).sendKeys(postCode);
    }

    public void clickSaveBtn() {
        AbstractPage.getElement(saveButton).click();
    }
}