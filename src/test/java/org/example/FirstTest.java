package org.example;

import org.junit.jupiter.api.Test;

public class FirstTest extends CommonTest {

    @Test
    public void start() {
        String name = "Мандарин";
        String type = "FRUIT";
        boolean exotic = true;
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm(name, type, exotic)
                .clickSave()
                .checkResult(name, type == "VEGETABLE" ? "Овощ" : "Фрукт", String.valueOf(exotic));
    }
}
