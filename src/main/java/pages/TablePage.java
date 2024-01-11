package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public TablePage clickAdd() {
        waitUtilElementToBeClickable(addBtn).click();
        return this;
    }

    public TablePage fillForm(String value, String key, Boolean exotc) {
        fillInputField(name, value);
        selectType.selectByValue(key);
        if (exotc==true) {
            exotic.click();
        }
        return this;
    }

    public TablePage clickSave() {
        waitUtilElementToBeClickable(saveBtn).click();
        return this;
    }
}
