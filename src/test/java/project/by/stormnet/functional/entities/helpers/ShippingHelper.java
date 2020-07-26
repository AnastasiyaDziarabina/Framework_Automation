package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.ShippingPage;

public class ShippingHelper extends AbstractHelper {

    private ShippingPage shippingPage = new ShippingPage();
    private String price = "//div[@class='delivery_option_price'][contains(text(), '$2.00')]";
    private String errorTerms = "//p[@class='fancybox-error'][contains(text(), 'You must agree')]";

    private static String deliveryPrice;

    public void chooseShippingWithTermsChecked() {
        setPriceOfDelivery();
        shippingPage.checkTermsOfServiceCheckbox();
        shippingPage.clickProceedToCheckoutBtn();
    }

    public boolean checkErrorIfTermsNOTChecked() {
        shippingPage.clickProceedToCheckoutBtnWithError();
        boolean result = isErrorDisplayedToCheckTerms();
        shippingPage.clickCloseErrorPopUp();
        return result;
    }

    public boolean isErrorDisplayedToCheckTerms() {
        AbstractPage.waitForElementVisible(By.xpath(errorTerms));
        return AbstractPage.getElement(errorTerms).isDisplayed();
    }

    public void setPriceOfDelivery() {
        AbstractPage.waitForElementVisible(By.xpath(price));
        deliveryPrice = AbstractPage.getElement(price).getText();
    }

    public static String getDeliveryPrice() {
        return deliveryPrice;
    }
}