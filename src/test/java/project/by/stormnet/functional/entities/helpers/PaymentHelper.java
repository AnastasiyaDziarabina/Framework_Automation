package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.PaymentPage;

public class PaymentHelper extends AbstractHelper {

    private PaymentPage paymentPage = new PaymentPage();
    private String priceOfDelivery = "//*[@id='total_shipping'][contains(text(), '$')]";
    private String itemPrice = "//td[@class='cart_total']//span[@class='price']";
    private String totalPr = "//span[@id='total_price'][contains(text(), '$')]";
    private String orderWillBeSentMessage = "//strong[contains(text(), 'Your order will be sent as soon as we receive payment.')]";

    private String expectedPriceDelivery;
    private String expectedPriceItem;
    private String actualPriceDelivery;
    private String actualPriceItem;
    private String totalPrc;

    private static double expPriceDelivery;
    private static double expPriceItem;
    private static double actPriceDelivery;
    private static double actPriceItem;
    private static double totalPrice;

    public boolean isItemPriceCorrect() {
        expectedPriceItem = SummaryCartHelper.getPriceOfItem();
        actualPriceItem = AbstractPage.getElement(itemPrice).getAttribute("innerText").trim();
        return actualPriceItem.equals(expectedPriceItem);
    }

    public boolean isDeliveryPriceCorrect() {
        expectedPriceDelivery = ShippingHelper.getDeliveryPrice();
        actualPriceDelivery = AbstractPage.getElement(priceOfDelivery).getAttribute("innerText").trim();
        return actualPriceDelivery.equals(expectedPriceDelivery);
    }

    public boolean isTotalAmountCorrect() {
        totalPrc = AbstractPage.getElement(totalPr).getAttribute("innerText").trim();
        paymentPage.remove$FromPriceAndParseToDouble(expectedPriceDelivery, actualPriceDelivery, expectedPriceItem, actualPriceItem, totalPrc);

        expPriceDelivery = PaymentPage.getExpPriceDelivery();
        expPriceItem = PaymentPage.getExpPriceItem();
        actPriceDelivery = PaymentPage.getActPriceDelivery();
        actPriceItem = PaymentPage.getActPriceItem();
        totalPrice = PaymentPage.getTotalPrice();

        double expectedResult = expPriceDelivery + expPriceItem;
        double actualResult = actPriceDelivery + actPriceItem;
        return expectedResult == actualResult && totalPrice == actualResult;
    }

    public void chooseBankWirePayment() {
        paymentPage.clickPayByBankWireBtn();
        paymentPage.clickIConfirmMyOrderButton();
    }

    public boolean checkMessageOrderWillBeSent() {
        return AbstractPage.getElement(orderWillBeSentMessage).isDisplayed();
    }
}