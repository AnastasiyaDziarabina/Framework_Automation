package project.by.stormnet.functional.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.*;
import project.by.stormnet.functional.entities.pages.AbstractPage;

@Test(priority = 4)
public class BuyItemTest {

    private HomeHelper homeHelper = new HomeHelper();
    private SearchHelper searchHelper = new SearchHelper();
    private SummaryCartHelper summaryCartHelper = new SummaryCartHelper();
    private AuthHelper authHelper = new AuthHelper();
    private AddressHelper addressHelper = new AddressHelper();
    private YourAddressHelper yourAddressHelper = new YourAddressHelper();
    private ShippingHelper shippingHelper = new ShippingHelper();
    private PaymentHelper paymentHelper = new PaymentHelper();
    private OrderHistoryHelper orderHistoryHelper = new OrderHistoryHelper();

    private static final String EMAIL = "kate@mailinator.com";
    private static final String PASSWORD = "qwerty123456";
    private static final String myItem = "blouse";
    private static final String ADDRESS = "5th avenue, 77887 Opa, Bluf";
    private static final String POSTCODE = "88877";

    @BeforeClass
    public void prepareToTest() {
        AbstractPage.openBrowser();
    }

    @DataProvider(name = "provideDataOfItems")
    public static Object[][] provideData() {
        return new Object[][]{{"skirt"}, {"blouse"}};
    }

    @Test(dataProvider = "provideDataOfItems")
    @Description(value = "Find items in catalog")
    @Severity(SeverityLevel.CRITICAL)
    public void foundItems(String itemName) {
        homeHelper.openHomePage();
        homeHelper.findItems(itemName);
        boolean isFound = searchHelper.checkFoundResults();
        Assert.assertTrue(isFound, "Nothing found.");
    }

    @Test(priority = 1)
    @Description(value = "Add found item in the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfCorrectItemAddedToCart() {
        homeHelper.openHomePage();
        homeHelper.findNeededItem(myItem);
        searchHelper.addItemToCart();
        searchHelper.clickOnProceedToCheckoutButton();
        boolean result = summaryCartHelper.isNeededItemAdded();
        summaryCartHelper.clickProceedToCheckoutButton();
        Assert.assertTrue(result, "Needed item is NOT added to cart.");
    }

    @Test(priority = 2)
    @Description(value = "Not sign in with invalid data when making order")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSignInWhenMakingOrderWithInvalidData() {
        String expectedResult = "There is 1 error";
        authHelper.signInWithInvalidData(EMAIL, PASSWORD);
        String actualResult = authHelper.checkInvalidLoginMessage();
        Assert.assertEquals(actualResult, expectedResult, "Error message is not displayed.");
    }

    @Test(priority = 3)
    @Description(value = "Sign in with valid data when making order")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSignInWhenMakingOrderWithValidData() {
        authHelper.signInWithValidData(EMAIL, PASSWORD);
        boolean loggedIn = authHelper.isLoggedIn();
        Assert.assertTrue(loggedIn, "User is not logged in.");
    }

    @Test(priority = 4)
    @Description(value = "Address should correspond to address when user signed up")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddressDisplayed() {
        boolean result = addressHelper.checkDisplayedOfDeliveryAddress();
        Assert.assertTrue(result, "Address is not displayed.");
    }

    @Test(priority = 5)
    @Description(value = "Update address info when making order")
    @Severity(SeverityLevel.BLOCKER)
    public void checkPossibilityUpdateAddress() {
        addressHelper.checkDisplayedOfDeliveryAddress();
        addressHelper.clickUpdateBtn();
        yourAddressHelper.updateAddressInfo(ADDRESS, POSTCODE);
        boolean isNewAddressUpdated = yourAddressHelper.getDeliveryStreet().equals(ADDRESS);
        addressHelper.clickProceededToCheckoutBtn();
        Assert.assertTrue(isNewAddressUpdated, "Address info is not updated.");
    }

    @Test(priority = 6)
    @Description(value = "No possible to continue without excepting Term&Conditions")
    @Severity(SeverityLevel.CRITICAL)
    public void checkErrorIfTermsNotChecked() {
        boolean result = shippingHelper.checkErrorIfTermsNOTChecked();
        Assert.assertTrue(result, "Error is not displayed.");
    }

    @Test(priority = 7)
    @Description(value = "Possible to continue with excepting Term&Conditions")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSuccessIfTermsChecked() {
        shippingHelper.chooseShippingWithTermsChecked();
        Assert.assertTrue(true, "Payment page is not opened.");
    }

    @Test(priority = 8)
    @Description(value = "Check if total amount (price of item + delivery price) correct")
    @Severity(SeverityLevel.BLOCKER)
    public void checkIfTotalAmountCorrect() {
        boolean priceItem = paymentHelper.isItemPriceCorrect();
        boolean priceDelivery = paymentHelper.isDeliveryPriceCorrect();
        boolean totalPrice = paymentHelper.isTotalAmountCorrect();
        Assert.assertTrue(priceItem, "Price of item is not correct.");
        Assert.assertTrue(priceDelivery, "Price of delivery is not correct.");
        Assert.assertTrue(totalPrice, "Total sum (delivery and price of item) is not correct.");
    }

    @Test(priority = 9)
    @Description(value = "Possibility to choose payment method")
    @Severity(SeverityLevel.CRITICAL)
    public void checkPaymentMethodCanBeChosen() {
        paymentHelper.chooseBankWirePayment();
        boolean isMessageOrderDisplayed = paymentHelper.checkMessageOrderWillBeSent();
        Assert.assertTrue(isMessageOrderDisplayed, "Can't choose payment method.");
    }

    @Test(priority = 10)
    @Description(value = "Check order displayed in history after making the order")
    @Severity(SeverityLevel.CRITICAL)
    public void checkOrderDisplayedInOrderHistory() {
        orderHistoryHelper.openOrderHistory();
        boolean isOrderTitleDisplayed = orderHistoryHelper.isOrderTitleDisplayed();
        Assert.assertTrue(isOrderTitleDisplayed, "Order is not displayed in order history.");
    }

    @AfterClass
    public void tearDown() {
        homeHelper.quit();
    }
}