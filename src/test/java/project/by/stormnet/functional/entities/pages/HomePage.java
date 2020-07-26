package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class HomePage extends AbstractPage {

    private String searchFiled = "//input[@class='search_query form-control ac_input']";
    private static String logoImg = "//img[@class='logo img-responsive']";
    private String searchButton = "//button[@type='submit'][@class='btn btn-default button-search']";
    private String searchPageTitle = "//h1[@class='page-heading  product-listing']";
    private String loginButton = "//a[@class='login']";
    private String myAccountButton = "//a[@title='Manage my customer account']";
    private String authTitle = "//h1[@class='page-heading'][contains(text(), 'Authentication')]";
    private String moreButton = "//a[@itemprop='url'][@title='View']//span[contains(text(), 'More')]";
    private String dataSheet = "//h3[@class='page-product-heading'][contains(text(), 'Data sheet')]";
    private String itemCard = "//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img";

    public static HomeHelper getHomePage() {
        HomeHelper homeHelper = new HomeHelper();
        waitForElementVisible(getElementBy(logoImg));
        System.out.println("Home page is opened");
        return homeHelper;
    }

    public HomeHelper navigateToHomePage() {
        AbstractPage.openUrl(shopURL);
        return getHomePage();
    }

    public void inputItemInSearchField(String itemName) {
        getElement((searchFiled)).sendKeys(itemName);
    }

    public void clickSearchButton() {
        getElement(searchButton).click();
        AbstractPage.waitForElementVisible(By.xpath(searchPageTitle));
    }

    public void clickLoginButton() {
        waitForElementVisible(By.xpath(loginButton));
        getElement(loginButton).click();
    }

    public void clickMyAccountBtn() {
        AbstractPage.waitForElementClickable(By.xpath(myAccountButton));
        getElement(myAccountButton).click();
        AbstractPage.waitForElementVisible(By.xpath(authTitle));
    }

    public void clickMoreBtn() {
        getElement(moreButton).click();
        waitForElementVisible(By.xpath(dataSheet));
    }

    public boolean isDetailsOpened() {
        scrollPage();
        return getElement(dataSheet).isDisplayed();
    }

    public void clickDetailsBtn() {
        waitForElementClickable(By.xpath(itemCard));
        getElement(itemCard).click();
        waitForElementVisible(By.xpath(dataSheet));
    }
}