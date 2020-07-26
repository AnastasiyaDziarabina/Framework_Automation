package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.OrderHistoryPage;

public class OrderHistoryHelper extends AbstractHelper {

    private OrderConfirmationHelper orderConfirmationHelper = new OrderConfirmationHelper();
    private OrderHistoryPage orderHistoryPage = new OrderHistoryPage();

    public void openOrderHistory() {
        orderConfirmationHelper.clickBackToOrderButton();
    }

    public boolean isOrderTitleDisplayed() {
        return orderHistoryPage.getMessageOrderExists().isDisplayed();
    }
}