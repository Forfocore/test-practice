package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondTest extends CommonTest {

    @Test
    public void start() {
        String name = "123450$%~?!";
        String type = "VEGETABLE";
        boolean exotic = false;
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm(name, type, exotic)
                .clickSave()
                .checkResult(name, type == "VEGETABLE" ? "Овощ" : "Фрукт", String.valueOf(exotic));

    }
}
