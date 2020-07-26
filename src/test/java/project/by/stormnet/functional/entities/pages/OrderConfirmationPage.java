package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage extends AbstractPage {

    private String backToOrderBtn = "//a[@title='Back to orders']";
    private String orderHistoryTitle = "//h1[@class='page-heading bottom-indent']";

    public void clickBackToOrderButton() {
        AbstractPage.getElement(backToOrderBtn).click();
        waitForElementVisible(By.xpath(orderHistoryTitle));
    }
}