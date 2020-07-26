package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.SearchPage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.*;

public class SearchHelper extends AbstractHelper {

    private static SearchPage searchPage = new SearchPage();
    private String foundResult = "//a[@class='product-name'][@title='Blouse']";
    private String addedItemMessage = "//h2/i[@class='icon-ok']";
    private String itemInfo = "//div[@class='primary_block row']";
    private String descriptionOfItem = "//*[@class='editable'][contains(text(), 'demo')]";
    private String priceOfItem = "//*[@id='our_price_display']";
    private String sizeOfItem = "//option[@selected='selected'][contains(text(), 'S')]";
    private String shoppingCartTitle = "//h1[@id='cart_title']";
    private String priceOfItem2 = "//span[@id='layer_cart_product_price']";
    private String deleteButton = "//i[@class='icon-trash']";
    private String addToCartButton = "//a[@title='Add to cart'][@data-id-product='5']";

    private static String expectedDescription;
    private static String expectedColorAndSize;
    private static String expectedPrice;
    private static String item2Price;

    public void openItemDetails() {
        if (getElement(foundResult).isDisplayed()) {
            searchPage.clickItemToOpenDetails();
        }
    }

    public void addItemToCart() {
        AbstractPage.waitForElementClickable(By.xpath(foundResult));
        openItemDetails();
        AbstractPage.waitForElementVisible(By.xpath(itemInfo));

        expectedDescription = getElement(descriptionOfItem).getAttribute("innerText").trim();
        expectedPrice = getElement(priceOfItem).getAttribute("innerText").trim();
        expectedColorAndSize = getElement(sizeOfItem).getAttribute("innerText").trim();

        searchPage.clickAddToCartButton();
        ifItemAdded();
    }

    public void addToCartAndOpenCart() {
        searchPage.clickAddToCartBtn();
        waitForElementVisible(By.xpath(addToCartButton));
        setPriceOfItem2();
        searchPage.clickOnProceedToCheckoutButton();
        scrollPage();
        waitForElementClickable(By.xpath(deleteButton));
    }

    public void setPriceOfItem2() {
        waitForElementVisible(By.xpath(priceOfItem2));
        item2Price = getElement(priceOfItem2).getAttribute("innerText").trim();
    }

    public String getExpectedPriceOfItem2() {
        return item2Price;
    }

    public void clickOnProceedToCheckoutButton() {
        searchPage.clickOnProceedToCheckoutButton();
        AbstractPage.waitForElementVisible(By.xpath(shoppingCartTitle));
    }

    private void ifItemAdded() {
        if (getElement(addedItemMessage).isDisplayed()) {
            System.out.println("Product successfully added to your shopping cart.");
        }
    }

    public String expectedDescriptionOfItem() {
        return expectedDescription;
    }

    public String expectedColorAndSize() {
        return expectedColorAndSize;
    }

    public String expectedPrice() {
        return expectedPrice;
    }

    public boolean checkFoundResults() {
        return !searchPage.getFoundResults().isEmpty();
    }

    public void continueShopping() {
        searchPage.clickContinueShopping();
    }
}