package pages;

import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TablePage extends CommonPage {

    @FindBy(className = "btn-primary")
    private WebElement addBtn;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "type")
    private WebElement type;

    private Select selectType = new Select(type);

    @FindBy(id = "exotic")
    private WebElement exotic;

    @FindBy(id = "save")
    private WebElement saveBtn;

    @FindBy(xpath = "//table[@class='table']/tbody")
    private List<WebElement> resultName;

    @Step("Нажимаем кнопку 'Добавить'")
    public TablePage clickAdd() {
        waitUtilElementToBeClickable(addBtn).click();
        return this;
    }

    @Step("Заполняем форму вводя данные {value}, {key} и {exotc}")
    public TablePage fillForm(String value, String key, String exotc) {
        boolean exotic2 = Boolean.parseBoolean(exotc);
        fillInputField(name, value);
        selectType.selectByValue(key);
        if (exotic2==true) {
            exotic.click();
        }
        return this;
    }

    @Step("Нажимаем кнопку 'Сохранить'")
    public TablePage clickSave() {
        waitUtilElementToBeClickable(saveBtn).click();
        return this;
    }

    @Step("Сравниваем фактический результат с ожидаемым")
    public TablePage checkResult(String name, String type, String exotic) {
        Assertions.assertEquals(name, resultName.get(resultName.size() - 1).findElement(By.xpath(".//tr[last()]/td[1]")).getText());
        Assertions.assertEquals(type, resultName.get(resultName.size() - 1).findElement(By.xpath(".//tr[last()]/td[2]")).getText());
        Assertions.assertEquals(exotic, resultName.get(resultName.size() - 1).findElement(By.xpath(".//tr[last()]/td[3]")).getText());
        return this;
    }
}
