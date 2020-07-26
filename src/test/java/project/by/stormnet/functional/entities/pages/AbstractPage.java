package project.by.stormnet.functional.entities.pages;

import by.stormnet.core.FrameworkCore;
import by.stormnet.core.utils.PauseLength;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore {

    private static WebDriver driver = getInstance();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openUrl(String URL) {
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void openBrowser() {
        driver = getInstance();
    }

    public static void waitForElementVisible(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void waitForElementClickable(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.elementToBeClickable(by));

        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public boolean isElementVisible(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(PauseLength.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0) {
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLength.MAX.value(), TimeUnit.SECONDS);
        }
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static By getElementBy(String xPath) {
        return By.xpath(xPath);
    }

    public static WebElement getElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public static List<WebElement> getElements(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public static void hoverOnItem(String item) {
        Actions action = new Actions(AbstractPage.getDriver());
        WebElement element = getElement(item);
        action.moveToElement(element).perform();
    }

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) AbstractPage.getDriver();
        js.executeScript("window.scrollBy(0,300)");
    }
}