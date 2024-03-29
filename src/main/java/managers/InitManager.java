package managers;

import java.util.concurrent.TimeUnit;

import static props.PropConst.IMPLICITLY_WAIT;
import static props.PropConst.PAGE_LOAD_TIMEOUT;

public class InitManager {

    private static final PropsManager props = PropsManager.getPropsManager();

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
