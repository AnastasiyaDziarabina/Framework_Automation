package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends AbstractPage {

    private String orderListTitle = "//th[@class='first_item footable-first-column']";

    public WebElement getMessageOrderExists() {
        return AbstractPage.getElement(orderListTitle);
    }
}