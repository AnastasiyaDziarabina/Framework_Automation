package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.ItemDetailsPage;

public class ItemDetailsHelper extends AbstractHelper {

    private ItemDetailsPage itemDetailsPage = new ItemDetailsPage();

    public boolean isPriceWithDiscountCorrect() {
        return itemDetailsPage.checkIfDiscountCorrect();
    }
}