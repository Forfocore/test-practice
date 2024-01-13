package org.example;

import org.junit.jupiter.api.Test;

public class FirstTest extends CommonTest {

    @Test
    public void start() {
        String name = "��������";
        String type = "FRUIT";
        boolean exotic = true;
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm(name, type, exotic)
                .clickSave()
                .checkResult(name, type == "VEGETABLE" ? "����" : "�����", String.valueOf(exotic));
    }
}
