package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.helpers.SearchHelper;

public class SummaryCartPage extends AbstractPage {

    private SearchHelper searchHelper = new SearchHelper();
    private String proceedToCheckoutButton = "//a[@href='http://automationpractice.com/index.php?controller=order&step=1']";
    private String title = "//h1[@class='page-heading']";
    private String actualPriceItem1 = "//span[@id='total_product_price_2_7_0']";
    private String actualPriceItem2 = "//span[@id='total_product_price_5_19_0']";
    private String deleteButton = "//i[@class='icon-trash']";
    private String cartIsEmptyMsg = "//p[@class='alert alert-warning'][contains(text(), 'Your shopping cart is empty.')]";

    public void clickProceedToCheckoutButton() {
        scrollPage();
        AbstractPage.getElement(proceedToCheckoutButton).click();
        AbstractPage.waitForElementVisible(By.xpath(title));
    }

    public String getActualPriceItem1() {
        return getElement(actualPriceItem1).getAttribute("innerText").trim();
    }

    public String getActualPriceItem2() {
        return getElement(actualPriceItem2).getAttribute("innerText").trim();
    }

    public boolean compareExpectedAndActualPriceItem1() {
        String expectedPriceItem1 = searchHelper.expectedPrice();
        String actualPriceItem1 = getActualPriceItem1();
        return expectedPriceItem1.contains(actualPriceItem1);
    }

    public boolean compareExpectedAndActualPriceItem12() {
        String expectedPriceItem2 = searchHelper.getExpectedPriceOfItem2();
        String actualPriceItem2 = getActualPriceItem2();
        return expectedPriceItem2.contains(actualPriceItem2);
    }

    public void clickDeleteItemBtn() {
        scrollPage();
        waitForElementClickable(By.xpath(deleteButton));
        AbstractPage.getElement(deleteButton).click();
        waitForElementVisible(By.xpath(cartIsEmptyMsg));
    }
}