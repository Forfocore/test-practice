package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest extends CommonTest {

    @DisplayName("������������ ���������� ������ � ������� � ��������� �������")
    @Test
    public void start() {
        String name = "��������";
        String type = "FRUIT";
        String exotic = "true";
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm(name, type, exotic)
                .clickSave()
                .checkResult(name, type == "VEGETABLE" ? "����" : "�����", exotic);
    }
}
