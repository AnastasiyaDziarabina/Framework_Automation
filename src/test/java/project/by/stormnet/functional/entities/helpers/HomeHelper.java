package project.by.stormnet.functional.entities.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import project.by.stormnet.functional.entities.pages.HomePage;

import static project.by.stormnet.functional.entities.pages.AbstractPage.*;

public class HomeHelper extends AbstractHelper {

    private HomePage homePage = new HomePage();
    private String resultItemPath = "//a[@class='product-name'][contains(text(), 'Blouse')][@itemprop='url']";
    private String authTitle = "//h1[@class='page-heading'][contains(text(), 'Authentication')]";
    private String itemCard = "//img[@class='replace-2x img-responsive'][@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']";
    private String moreButton = "//a[@itemprop='url'][@title='View']//span[contains(text(), 'More')]";
    private String searchBreadcrumbs = "//span[@class='navigation_page'][contains(text(), 'Search')]";

    public void openHomePage() {
        homePage.navigateToHomePage();
    }

    public void findNeededItem(String itemName) {
        homePage.inputItemInSearchField(itemName);
        homePage.clickSearchButton();
        AbstractPage.waitForElementClickable(By.xpath(resultItemPath));
        if (AbstractPage.getElement(resultItemPath).isDisplayed()) {
            System.out.println("My result is found: " + itemName);
        }
    }

    public void findItems(String itemName) {
        homePage.inputItemInSearchField(itemName);
        homePage.clickSearchButton();
        waitForElementVisible(By.xpath(searchBreadcrumbs));
    }

    public void openLoginPage() {
        homePage.clickLoginButton();
        AbstractPage.waitForElementVisible(By.xpath(authTitle));
    }

    public void openAuthPageFromHeader() {
        scrollPage();
        AbstractPage.wait(500);
        scrollPage();
        homePage.clickMyAccountBtn();
    }

    public void openDetailsOfItem() {
        scrollPage();
        AbstractPage.wait(500);
        scrollPage();
        waitForElementVisible(By.xpath(itemCard));
        AbstractPage.hoverOnItem(itemCard);
        AbstractPage.waitForElementClickable(By.xpath(moreButton));
        homePage.clickMoreBtn();
    }
}