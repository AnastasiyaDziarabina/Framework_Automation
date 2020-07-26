package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class ShippingPage extends AbstractPage {
    private String iAgreeToTermsOfService = "//label[@for='cgv'][contains(text(), 'I agree to the terms of service and will adhere to them unconditionally.')]";
    private String proceedToCheckout = "//button[@class='button btn btn-default standard-checkout button-medium']";

    private String paymentTitle = "//h1[@class='page-heading'][contains(text(), 'Please choose your payment method')]";
    private String closeErrorPopUp = "//a[@title='Close'][@class='fancybox-item fancybox-close']";

    public void checkTermsOfServiceCheckbox() {
        AbstractPage.getElement(iAgreeToTermsOfService).click();
    }

    public void clickProceedToCheckoutBtn() {
        AbstractPage.getElement(proceedToCheckout).click();
        waitForElementVisible(By.xpath(paymentTitle));
        scrollPage();
    }

    public void clickProceedToCheckoutBtnWithError() {
        AbstractPage.getElement(proceedToCheckout).click();
        waitForElementClickable(By.xpath(closeErrorPopUp));
    }

    public void clickCloseErrorPopUp() {
        AbstractPage.getElement(closeErrorPopUp).click();
        waitForElementVisible(By.xpath(iAgreeToTermsOfService));
    }
}