package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.YourAddressPage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.scrollPage;

public class YourAddressHelper extends AbstractHelper {

    private YourAddressPage yourAddressPage = new YourAddressPage();

    private static String address;
    private String addressTitle = "//h1[@class='page-heading']";
    private String streetInfo = "//*[@id='address_delivery']/li[@class='address_address1 address_address2']";

    public void updateAddressInfo(String newAddress, String newPostCode) {
        yourAddressPage.clearAddressField();
        yourAddressPage.inputNewAddress(newAddress);
        yourAddressPage.clearPostCodeField();
        yourAddressPage.inputNewPostCode(newPostCode);
        yourAddressPage.clickSaveBtn();
        AbstractPage.waitForElementVisible(By.xpath(addressTitle));
        scrollPage();
        address = AbstractPage.getElement(streetInfo).getAttribute("innerText").trim();
    }

    public String getDeliveryStreet() {
        return address;
    }
}