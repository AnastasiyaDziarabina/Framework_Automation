package project.by.stormnet.functional.entities.pages;

public class YourPersonalInfoPage extends AddressPage {

    private String firstNameField = "//input[@id='firstname']";
    private String lastNameField = "//input[@name='lastname']";
    private String namesFromHeader = "//a[@title='View my customer account'][@rel='nofollow']//span";

    public String getFirstName() {
        return getElement(firstNameField).getAttribute("innerText").trim();
    }

    public String getLastName() {
        return getElement(lastNameField).getAttribute("innerText").trim();
    }

    public String getNamesFromHeader() {
        return getElement(namesFromHeader).getAttribute("innerText").trim();
    }
}