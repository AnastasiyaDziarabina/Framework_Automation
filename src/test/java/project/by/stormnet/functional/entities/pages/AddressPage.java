package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class AddressPage extends AbstractPage {

    private String updateButton = "//ul[@class='address item box']//span[contains(text(), 'Update')]";
    private String proceededToCheckoutButton = "//button[@class='button btn btn-default button-medium']";
    private String shippingTitle = "//h1[@class='page-heading'][contains(text(), 'Shipping')]";

    public void clickUpdateBtn() {
        AddressPage.getElement(updateButton).click();
    }

    public void clickProceededToCheckoutBtn() {
        AbstractPage.getElement(proceededToCheckoutButton).click();
        waitForElementVisible(By.xpath(shippingTitle));
    }
}