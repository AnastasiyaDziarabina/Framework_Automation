package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.OrderConfirmationPage;

public class OrderConfirmationHelper extends AbstractHelper {

    private OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    public void clickBackToOrderButton() {
        orderConfirmationPage.clickBackToOrderButton();
    }
}