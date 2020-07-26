package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class AbstractHelper {

    public void quit() {
        AbstractPage.getDriver().quit();
    }
}