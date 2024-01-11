package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if (INSTANCE==null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver==null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }

    private void initDriver() {
        driver = new ChromeDriver();
    }
}
