package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static props.PropConst.*;

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

    private void initDriver()
    {
        if ("remote".equalsIgnoreCase(PropsManager.getPropsManager().getProperty(TYPE_DRIVER))) {
            initRemoteDriver();
        }
        else {
            switch (PropsManager.getPropsManager().getProperty(TYPE_BROWSER)) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
            }
        }
    }

    private void initRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(PropsManager.getPropsManager().getProperty(TYPE_BROWSER));
        capabilities.setVersion("109.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        try {
            driver = new RemoteWebDriver(URI.create(PropsManager.getPropsManager().getProperty(SELENOID_URL)).toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
