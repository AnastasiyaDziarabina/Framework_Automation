package project.by.stormnet.functional.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.*;
import project.by.stormnet.functional.entities.pages.AbstractPage;

@Test(priority = 5)
public class TestWithItem {

    private HomeHelper homeHelper = new HomeHelper();
    private SearchHelper searchHelper = new SearchHelper();
    private SummaryCartHelper summaryCartHelper = new SummaryCartHelper();
    private ItemDetailsHelper itemDetailsHelper = new ItemDetailsHelper();

    private static final String myItem = "blouse";
    private static final String myItem2 = "dress";

    @BeforeClass
    public void prepareToTest() {
        AbstractPage.openBrowser();
    }

    @Test
    @Description(value = "Delete item from cart")
    @Severity(SeverityLevel.CRITICAL)
    public void checkPossibilityDeleteItemFromCard() {
        homeHelper.openHomePage();
        homeHelper.findNeededItem(myItem2);
        searchHelper.addToCartAndOpenCart();
        summaryCartHelper.deleteItemFromCart();
        boolean isDeletedFromCart = summaryCartHelper.isItemDeleted();
        Assert.assertTrue(isDeletedFromCart, "Item is not deleted.");
    }

    @Test
    @Description(value = "Check the price is correct in cart")
    @Severity(SeverityLevel.BLOCKER)
    public void checkIfAmountIsCorrectInCart() {
        homeHelper.openHomePage();
        homeHelper.findNeededItem(myItem);
        searchHelper.addItemToCart();
        searchHelper.continueShopping();
        homeHelper.findItems(myItem2);
        searchHelper.addToCartAndOpenCart();
        summaryCartHelper.deleteItemsFromCart();
        boolean isPriceItem1Correct = summaryCartHelper.isPriceItem1Correct();
        boolean isPriceItem2Correct = summaryCartHelper.isPriceItem2Correct();
        Assert.assertTrue(isPriceItem1Correct, "Price of item" + myItem + " is not correct.");
        Assert.assertTrue(isPriceItem2Correct, "Price of item" + myItem2 + " is not correct.");
    }

    @Test
    @Description(value = "Check the price after discount is correct")
    @Severity(SeverityLevel.BLOCKER)
    public void checkIfPriceWithDiscountCorrect() {
        homeHelper.openHomePage();
        homeHelper.findItems(myItem2);
        homeHelper.openDetailsOfItem();
        boolean isPriceCorrect = itemDetailsHelper.isPriceWithDiscountCorrect();
        Assert.assertTrue(isPriceCorrect, "Price is not correct.");
    }

    @Test
    @Description(value = "Open details of item from home page")
    @Severity(SeverityLevel.NORMAL)
    public void checkOpeningItemDetailsFromHomePage() {
        homeHelper.openHomePage();
        homeHelper.openDetailsOfItemFromHomePage();
        boolean isDetailsOpened = homeHelper.isDetailsOpened();
        Assert.assertTrue(isDetailsOpened, "Details of item is not opened.");
    }

    @AfterClass
    public void tearDown() {
        homeHelper.quit();
    }
}