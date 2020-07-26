package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends AbstractPage {

    private String itemCard = "//div[@class='product-image-container']";
    private String titleOfItem = "//a[@class='product-name'][@title='Blouse']";
    private String addToCartFromDetailsButton = "//*[@id='add_to_cart']/button/span[contains(text(), 'Add to cart')]";
    private String addedItemMessage = "//h2/i[@class='icon-ok']";
    private String proceedToCheckoutButton = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span";
    private String popUpToOpenCart = "//div[@class='layer_cart_cart col-xs-12 col-md-6']";
    private String listOfItems = "//ul[@class='product_list grid row']";
    private String continueShoppingButton = "//i[@class='icon-chevron-left left']";
    private String searchFiled = "//input[@class='search_query form-control ac_input']";
    private String addToCartButton = "//a[@title='Add to cart'][@data-id-product='5']";
    private String shoppingCartTitle = "//h1[@id='cart_title']";


    public void clickItemToOpenDetails() {
        hoverOnItem(itemCard);
        getElement(titleOfItem).click();
        waitForElementVisible(By.xpath(addToCartFromDetailsButton));
    }

    public void clickAddToCartButton() {
        getElement(addToCartFromDetailsButton).click();
        AbstractPage.waitForElementClickable(By.xpath(addedItemMessage));
    }

    public void clickOnProceedToCheckoutButton() {
        waitForElementVisible(By.xpath(popUpToOpenCart));
        getElement(proceedToCheckoutButton).click();
        waitForElementVisible(By.xpath(shoppingCartTitle));
    }

    public List<WebElement> getFoundResults() {
        List<WebElement> webItems;
        webItems = AbstractPage.getElements(listOfItems);
        return webItems;
    }

    public void clickAddToCartBtn() {
        scrollPage();
        waitForElementVisible(By.xpath(itemCard));
        hoverOnItem(itemCard);
        waitForElementClickable(By.xpath(addToCartButton));
        getElement(addToCartButton).click();
        waitForElementClickable(By.xpath(proceedToCheckoutButton));
    }

    public void clickContinueShopping() {
        getElement(continueShoppingButton).click();
        waitForElementClickable(By.xpath(searchFiled));
        clearSearchField();
    }

    private void clearSearchField() {
        getElement(searchFiled).clear();
    }
}