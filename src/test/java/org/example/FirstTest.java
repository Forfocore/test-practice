package org.example;

import org.junit.Test;

public class FirstTest extends CommonTest {

    @Test
    public void start() {
        app.getFirstPage()
                .selectMenu()
                .selectFood()
                .clickAdd()
                .fillForm("Мандарин", "FRUIT", true)
                .clickSave();
    }
}
