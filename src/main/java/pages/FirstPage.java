package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends CommonPage {

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    private WebElement menu;

    @FindBy(xpath = "//a[@href='/food']")
    private WebElement food;

    public FirstPage selectMenu() {
        waitUtilElementToBeClickable(menu).click();
        return this;
    }

    public TablePage selectFood() {
        waitUtilElementToBeClickable(food).click();
        return pageManager.getTablePage();
    }
}
