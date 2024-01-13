package org.example;

import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropsManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static props.PropConst.BASE_URL;

public class CommonTest {

    protected PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_URL));
    }


    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }

}
