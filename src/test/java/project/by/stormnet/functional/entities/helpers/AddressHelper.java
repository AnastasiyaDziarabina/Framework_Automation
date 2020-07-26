package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AddressPage;
import project.by.stormnet.functional.entities.pages.HomePage;

public class AddressHelper extends AbstractHelper {

    private HomePage homePage = new HomePage();
    private AddressPage addressPage = new AddressPage();

    private String deliveryAddress = "//h3[@class='page-subheading'][contains(text(), 'Your delivery address')]";

    public boolean checkDisplayedOfDeliveryAddress() {
        return homePage.isElementVisible(By.xpath(deliveryAddress));
    }

    public void clickUpdateBtn() {
        addressPage.clickUpdateBtn();
    }

    public void clickProceededToCheckoutBtn() {
        addressPage.clickProceededToCheckoutBtn();
    }
}