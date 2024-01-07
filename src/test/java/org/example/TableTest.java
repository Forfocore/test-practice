package org.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TableTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/food");
        driver.manage().window().maximize();

    }



    @Test
    public void testAdd() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();
        WebElement name = driver.findElement(By.id("name"));
        WebElement type = driver.findElement(By.id("type"));
        Select selectType = new Select(type);
        WebElement exotic = driver.findElement(By.id("exotic"));
        WebElement saveBtn = driver.findElement(By.id("save"));
        name.sendKeys("Мандарин");
        selectType.selectByValue("FRUIT");
        exotic.click();
        saveBtn.click();

    }

    @Test
    public void testAdd2() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();
        WebElement name = driver.findElement(By.id("name"));
        WebElement type = driver.findElement(By.id("type"));
        Select selectType = new Select(type);
        WebElement exotic = driver.findElement(By.id("exotic"));
        WebElement saveBtn = driver.findElement(By.id("save"));
        name.sendKeys("123450$%~?!");
        selectType.selectByValue("VEGETABLE");
        saveBtn.click();

    }
}
