package org.example;

import io.cucumber.java.ru.И;
import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropsManager;

import org.junit.jupiter.api.*;

import static props.PropConst.BASE_URL;

@DisplayName("Постусловия и предусловия для тестирования Web")
public class CommonTest {

    protected PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();





    @BeforeEach
    public void beforeEach() {
        InitManager.initFramework();
        driverManager.getDriver().get(PropsManager.getPropsManager().getProperty(BASE_URL));
    }


    @AfterAll
    public static void afterAll() {

    }


}
