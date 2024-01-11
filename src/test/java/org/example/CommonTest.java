package org.example;

import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropsManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static props.PropConst.BASE_URL;

public class CommonTest {

    protected PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_URL));
    }

    /*
    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
     */
}
