package org.example;

import managers.JDBCManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class JDBCTest extends CommonTest {

    @DisplayName("������������ ���������� ������ � �� ��� ������ JDBC � � ����������� ��������")
    @Test
    public void start() throws SQLException {
        JDBCManager jdbcManager = JDBCManager.getJDBCManager();

        int id = 100;
        String name = "��������";
        String type = "FRUIT";
        int exotic = 1;

        jdbcManager.selectAll();
        jdbcManager.addRow(id, name, type, exotic);
        jdbcManager.checkAdd(id, name, type, exotic);
        jdbcManager.deleteById(id);
        jdbcManager.checkDeleted(id);
    }

}
