package org.example.steps;

import io.cucumber.java.ru.И;
import managers.JDBCManager;

import java.sql.SQLException;

public class DBSteps {
    JDBCManager jdbcManager;

    {
        try {
            jdbcManager = JDBCManager.getJDBCManager();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @И("Добавить строку с ID - {int}, названием - {string}, типом - {string}, и экзотичный - {int}")
    public void addRow(int id, String name, String type, int exotic) throws SQLException {
        jdbcManager.addRow(id, name, type, exotic);
    }

    @И("Проверяется, что строка с ID - {int}, названием - {string}, типом - {string}, и экзотичный - {int} добавлена")
    public void checkAdd(int id, String name, String type, int exotic) throws SQLException {
        jdbcManager.checkAdd(id, name, type, exotic);
    }

    @И("Удалить строку с ID - {int}")
    public void deleteById(int id) throws SQLException {
        jdbcManager.deleteById(id);
    }

    @И("Проверяется, что строка с ID - {int} удалена")
    public void checkDeleted(int id) throws SQLException {
        jdbcManager.checkDeleted(id);
    }
}
