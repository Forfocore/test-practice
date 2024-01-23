package org.example.steps;

import io.cucumber.java.ru.И;
import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropsManager;
import pages.FirstPage;
import pages.TablePage;


public class Steps {

    protected PageManager app = PageManager.getPageManager();

    FirstPage firstPage;

    TablePage tablePage;

    private final DriverManager driverManager = DriverManager.getDriverManager();


    @И("открыта страница по адресу {string}")
    public void beforeEach(String string1) {
        InitManager.initFramework();
        driverManager.getDriver().get(string1);
    }

    @И("выполнено нажатие на кнопку 'Песочница'")
    public void selectMenu() {
        firstPage = app.getFirstPage().selectMenu();
    }

    @И("выполнено нажатие на кнопку 'Товары'")
    public void selectSubMenu() {
        firstPage.selectFood();
    }

    @И("выполнено нажатие на кнопку 'Добавить'")
    public void clickAdd() {
        tablePage = app.getTablePage().clickAdd();
    }

    @И("значение поля 'Имя' заполняется значением {string}," +
            " значение поля 'Тип' заполняется значением {string}," +
            " значение поля 'Экзотический' заполняется значением {string}")
    public void fillForm(String name, String type, String exotic) {
        tablePage = tablePage.fillForm(name, type, exotic);
    }

    @И("выполнено нажатие на кнопку 'Сохранить'")
    public void clickSave() {
        tablePage = tablePage.clickSave();
    }

    @И("результат проверяется со значениями {string}, {string}, {string}")
    public void checkResult(String name, String type, String exotic) {
        tablePage = tablePage.checkResult(name, type, exotic);
    }
}
