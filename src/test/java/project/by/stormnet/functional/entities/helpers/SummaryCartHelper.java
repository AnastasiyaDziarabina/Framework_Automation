package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.SummaryCartPage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.*;

public class SummaryCartHelper extends AbstractHelper {

    private SummaryCartPage summaryCartPage = new SummaryCartPage();
    private static String actualDescription;
    private static String actualColorAndSize;
    private static String actualPrice;
    private SearchHelper searchHelper = new SearchHelper();
    private String nameOfItem = "//p//a[@href='http://automationpractice.com/index.php?id_product=2&controller=product#/size-s/color-black'][contains(text(), 'Blouse')]";
    private String descriptionOfItem = "//small[@class='cart_ref'][contains(text(), 'SKU : demo_2')]";
    private String colorAndSizeOfItem = "//a[contains(text(), 'Color : Black, Size : S')]";
    private String priceOfItem = "//td[@class='cart_unit']//span[@class='price'][contains(text(), '27')]";
    private String cartIsEmptyMsg = "//p[@class='alert alert-warning'][contains(text(), 'Your shopping cart is empty.')]";
    private String deleteButton = "//a[@title='Delete']//i[@class='icon-trash']";

    public void getInfoAboutItem() {
        waitForElementVisible(By.xpath(nameOfItem));

        actualDescription = AbstractPage.getElement(descriptionOfItem).getAttribute("innerText").trim();
        actualColorAndSize = AbstractPage.getElement(colorAndSizeOfItem).getAttribute("innerText").trim();
        actualPrice = AbstractPage.getElement(priceOfItem).getAttribute("innerText").trim();
    }

    public static String getPriceOfItem() {
        return actualPrice;
    }

    public boolean isNeededItemAdded() {
        getInfoAboutItem();
        int counter = 0;

        if (actualDescription.contains(searchHelper.expectedDescriptionOfItem())) {
            counter++;
        }
        if (actualColorAndSize.contains(searchHelper.expectedColorAndSize())) {
            counter++;
        }
        if (actualPrice.contains(searchHelper.expectedPrice())) {
            counter++;
        }
        return counter == 3;
    }

    public void clickProceedToCheckoutButton() {
        summaryCartPage.clickProceedToCheckoutButton();
    }

    public boolean isPriceItem1Correct() {
        return summaryCartPage.compareExpectedAndActualPriceItem1();
    }

    public boolean isPriceItem2Correct() {
        return summaryCartPage.compareExpectedAndActualPriceItem12();
    }

    public void deleteItemFromCart() {
        summaryCartPage.clickDeleteItemBtn();
    }

    public void deleteItemsFromCart() {
        if (getElement(deleteButton).isDisplayed()) {
            summaryCartPage.clickDeleteItemBtn();
            waitForElementClickable(By.xpath(deleteButton));
            summaryCartPage.clickDeleteItemBtn();
        }
    }

    public boolean isItemDeleted() {
        AbstractPage.wait(2000);
        return getElement(cartIsEmptyMsg).isDisplayed();
    }
}