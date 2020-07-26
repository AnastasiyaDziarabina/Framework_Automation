package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class ItemDetailsPage extends AbstractPage {

    private String oldPrice = "//span[@id='old_price_display']";
    private String discount = "//span[@id='reduction_percent_display']";
    private String newPrice = "//span[@id='our_price_display']";

    private static String oldPriceStrg;
    private static String discountStrg;
    private static String newPriceStrg;

    private static Double oldPriceDbl;
    private static Double discountDbl;
    private static Double newPriceDbl;

    public boolean checkIfDiscountCorrect() {
        setOldPrice();
        setDiscountValue();
        setPriceWithDiscount();
        remove$FromPriceAndParseToDouble();
        waitForElementVisible(By.xpath(discount));
        return countDiscount();
    }

    private void setOldPrice() {
        oldPriceStrg = getElement(oldPrice).getAttribute("innerText").trim();
    }

    private void setDiscountValue() {
        discountStrg = getElement(discount).getAttribute("innerText").trim();
    }

    private void setPriceWithDiscount() {
        newPriceStrg = getElement(newPrice).getAttribute("innerText").trim();
    }

    private void remove$FromPriceAndParseToDouble() {
        oldPriceStrg = oldPriceStrg.replace("$", "");
        discountStrg = discountStrg.replace("%", "");
        discountStrg = discountStrg.replace("-", "");
        newPriceStrg = newPriceStrg.replace("$", "");
        parseStringPriceToDouble();
    }

    private void parseStringPriceToDouble() {
        oldPriceDbl = Double.parseDouble(oldPriceStrg);
        discountDbl = Double.parseDouble(discountStrg);
        newPriceDbl = Double.parseDouble(newPriceStrg);
    }

    private boolean countDiscount() {
        double priceWithDiscount = (oldPriceDbl * (1 - discountDbl / 100));
        double roundedPriceWithDiscount = Math.round(priceWithDiscount * 100.0) / 100.0;
        return newPriceDbl == roundedPriceWithDiscount;
    }
}