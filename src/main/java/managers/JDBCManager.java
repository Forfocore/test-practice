package managers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.sql.*;
import java.sql.DriverManager;

import static props.PropConst.*;

public class JDBCManager {


    private static JDBCManager jdbcManager;

    public JDBCManager() throws SQLException {
    }

    public static JDBCManager getJDBCManager() throws SQLException {
        if (jdbcManager==null) {
            jdbcManager = new JDBCManager();
        }
        return jdbcManager;
    }

    private Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/mem:testdb", "user", "pass");

    private Statement statement = connection.createStatement();
    private PreparedStatement preparedStatement;



    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    @Step("Выбираем все данные из таблицы")
    public void selectAll() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM FOOD");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("FOOD_ID");
            String name =
                    resultSet.getString("FOOD_NAME");
            String type = resultSet.getString("FOOD_TYPE");
            boolean exotic = resultSet.getBoolean("FOOD_EXOTIC");
            System.out.printf(id + " " +
                    name + " " + type + " " + exotic + "\n");
        }
    }

    @Step("Добавляем строку с данными {id}, {name}, {type}, {exotic}")
    public void addRow(int id, String name, String type, int exotic) throws SQLException {
        String insert = "INSERT INTO FOOD VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, type);
        preparedStatement.setInt(4, exotic);
        preparedStatement.executeUpdate();
    }

    @Step("Проверяем добавленные данные")
    public void checkAdd(int id, String name, String type, int exotic) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM FOOD WHERE FOOD_ID = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int foodId = resultSet.getInt("FOOD_ID");
        String foodName =
                resultSet.getString("FOOD_NAME");
        String foodType = resultSet.getString("FOOD_TYPE");
        boolean foodExotic = resultSet.getBoolean("FOOD_EXOTIC");
        Assertions.assertEquals(id, foodId);
        Assertions.assertEquals(name, foodName);
        Assertions.assertEquals(type, foodType);
        Assertions.assertEquals(exotic, foodExotic == true ? 1 : 0);

    }

    @Step("Удаляем запись с ID {id}")
    public void deleteById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM FOOD WHERE FOOD_ID = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Step("Проверяем удалена ли запись с ID {id}")
    public void checkDeleted(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM FOOD");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int foodId = resultSet.getInt("FOOD_ID");
            Assertions.assertFalse(foodId==id);
        }
    }
}