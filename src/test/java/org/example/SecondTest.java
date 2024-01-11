package org.example;

import org.junit.Test;

public class SecondTest extends CommonTest {

    @Test
    public void start() {
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm("123450$%~?!", "VEGETABLE", false)
                .clickSave();
    }
}
