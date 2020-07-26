package project.by.stormnet.functional.entities.pages;

import org.openqa.selenium.By;

public class CreateAccountPage extends AbstractPage {

    private String homePageTitle = "//ul[@id='home-page-tabs']";
    private String genderButton = "//label[@for='id_gender2']";
    private String firstNameField = "//input[@name='customer_firstname']";
    private String lastNameField = "//input[@id='customer_lastname']";
    private String passwordField = "//input[@type='password']";
    private String addressField = "//input[@id='address1']";
    private String cityField = "//input[@id='city']";
    private String stateDropdown = "//select[@id='id_state']";
    private String stateField = "//select[@name='id_state']/option[@value='1']";
    private String postcodeField = "//input[@id='postcode']";
    private String mobilePhoneField = "//input[@id='phone_mobile']";
    private String myAddressField = "//input[@id='alias']";
    private String registerButton = "//button[@id='submitAccount']";
    private String errorMessage = "//div[@class='alert alert-danger']";
    private String errorPasswordMessage = "//div[@class='alert alert-danger']/ol/li/b[contains(text(), 'passwd')]";
    private String emailExistError = "//*[@id='create_account_error']/ol/li[contains(text(), 'An account using this email address has already been registered.')]";
    private String invalidEmailError = "//*[@id='create_account_error']/ol/li[contains(text(), 'Invalid email address.')]";
    private String homeButton = "//a[@class='home']";
    private String myAccountTitle = "//h1[@class='page-heading'][contains(text(), 'My account')]";

    private String firstName = "Alex";
    private String lastName = "Chivas";
    private String password = "12345";
    private String address = "Bk Street";
    private String city = "Vancouver";
    private String postcode = "96704";
    private String phone = "123456789";
    private String myAddress = "fyujnbghjmnh";

    public void clickGenderButton() {
        waitForElementClickable(getElementBy(genderButton));
        getElement(genderButton).click();
    }

    public void inputFirstName() {
        getElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName() {
        getElement(lastNameField).sendKeys(lastName);
    }

    public void inputPassword() {
        getElement(passwordField).sendKeys(password);
    }

    public void inputInvalidPassword(String password) {
        getElement(passwordField).sendKeys(password);
    }

    public void inputAddress() {
        getElement(addressField).sendKeys(address);
    }


    public void inputCity() {
        getElement(cityField).sendKeys(city);
    }


    public void clickStateBtn() {
        waitForElementVisible(By.xpath(stateDropdown));
        getElement(stateField).click();
        waitForElementClickable(By.xpath(stateField));
    }

    public void inputPostCode() {
        waitForElementClickable(By.xpath(postcodeField));
        getElement(postcodeField).sendKeys(postcode);
    }

    public void inputPhoneNumber() {
        waitForElementClickable(By.xpath(mobilePhoneField));
        getElement(mobilePhoneField).sendKeys(phone);
    }

    public void inputMyAddress() {
        waitForElementClickable(By.xpath(myAddressField));
        getElement(myAddressField).sendKeys(myAddress);
    }

    public void clickRegisterBtn() {
        getElement(registerButton).click();
        waitForElementVisible(By.xpath(myAccountTitle));
    }

    public boolean checkErrorInfoMessage() {
        waitForElementVisible(By.xpath(errorMessage));
        return isElementVisible(getElementBy(errorMessage));
    }

    public boolean checkErrorPasswordMessageText() {
        waitForElementVisible(By.xpath(errorPasswordMessage));
        return getElement(errorPasswordMessage).isDisplayed();
    }

    public boolean checkErrorSignUpMessage() {
        waitForElementVisible(By.xpath(emailExistError));
        return getElement(emailExistError).isDisplayed();
    }

    public boolean checkErrorInvalidEmail() {
        waitForElementVisible(By.xpath(invalidEmailError));
        return getElement(invalidEmailError).isDisplayed();
    }

    public void clickRegisterBtnError() {
        getElement(registerButton).click();
        waitForElementVisible(By.xpath(errorMessage));
    }

    public void clickHomeButton() {
        getElement(homeButton).click();
        waitForElementVisible(By.xpath(homePageTitle));
    }
}