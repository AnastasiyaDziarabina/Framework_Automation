package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class PaymentPage extends AbstractPage {

    private String payByBankWire = "//a[@class='bankwire']";
    private String bankWirePaymentTitle = "//h3[@class='page-subheading']";
    private String iConfirmOrderButton = "//*[@id='cart_navigation']/button/span[contains(text(), 'I confirm my order')]";

    private static String expectedPriceDelivery;
    private static String expectedPriceItem;
    private static String actualPriceDelivery;
    private static String actualPriceItem;
    private static String total;

    private static double expPriceDelivery;
    private static double expPriceItem;
    private static double actPriceDelivery;
    private static double actPriceItem;
    private static double totalPrice;


    public void remove$FromPriceAndParseToDouble(String ePriceDelivery, String aPriceDelivery, String ePriceItem, String aPriceItem, String ttlPrice) {
        expectedPriceDelivery = ePriceDelivery.replace("$", "");
        expectedPriceItem = ePriceItem.replace("$", "");
        actualPriceDelivery = aPriceDelivery.replace("$", "");
        actualPriceItem = aPriceItem.replace("$", "");
        total = ttlPrice.replace("$", "");

        parseStringPriceToDouble();
    }

    private void parseStringPriceToDouble() {
        expPriceDelivery = Double.parseDouble(expectedPriceDelivery);
        expPriceItem = Double.parseDouble(expectedPriceItem);
        actPriceDelivery = Double.parseDouble(actualPriceDelivery);
        actPriceItem = Double.parseDouble(actualPriceItem);
        totalPrice = Double.parseDouble(total);
    }

    public static double getExpPriceDelivery() {
        return expPriceDelivery;
    }

    public static double getExpPriceItem() {
        return expPriceItem;
    }

    public static double getActPriceDelivery() {
        return actPriceDelivery;
    }

    public static double getActPriceItem() {
        return actPriceItem;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }

    public void clickPayByBankWireBtn() {
        AbstractPage.getElement(payByBankWire).click();
        waitForElementVisible(By.xpath(bankWirePaymentTitle));
    }

    public void clickIConfirmMyOrderButton() {
        AbstractPage.getElement(iConfirmOrderButton).click();
        waitForElementVisible(By.xpath("//h1[@class='page-heading'][contains(text(), 'Order confirmation')]"));
    }
}