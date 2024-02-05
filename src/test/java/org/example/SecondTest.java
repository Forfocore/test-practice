package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondTest extends CommonTest {



    @DisplayName("Тестирование добавления записи в таблицу с нетипичными данными")
    @Test
    public void start() {
        String name = "123450$&!";
        String type = "VEGETABLE";
        String exotic = "false";
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm(name, type, exotic)
                .clickSave()
                .checkResult(name, type == "VEGETABLE" ? "Овощ" : "Фрукт", exotic);

    }
}
