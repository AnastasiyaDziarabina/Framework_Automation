package by.stormnet.core;

import by.stormnet.core.utils.BrowserConstance;
import by.stormnet.core.utils.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkCore {

    private static WebDriver driver;
    public static String browser = IOUtils.loadGenericProperty("browser", "configuration");
    public static String shopURL = IOUtils.loadGenericProperty("shopURL", "configuration");

    public static WebDriver getInstance() {
        if (browser.equals(BrowserConstance.CHROME)) {
            driver = new ChromeDriver();
        } else {
            if (browser.equals(BrowserConstance.FIREFOX)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser value from property file is incorrect");
            }
        }
        return driver;
    }
}