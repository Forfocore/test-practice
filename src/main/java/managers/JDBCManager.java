package managers;

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

    public void selectAll() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM FOOD");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("FOOD_ID");
            String name =
                    resultSet.getString("FOOD_NAME");
            String type = resultSet.getString("FOOD_TYPE");
            boolean exotic = resultSet.getBoolean("FOOD_EXOTIC");
            System.out.printf(String.valueOf(id) + " " +
                    name + " " + type + " " + String.valueOf(exotic) + "\n");
        }
    }

    public void addRow(int id, String name, String type, int exotic) throws SQLException {
        String insert = "INSERT INTO FOOD VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, type);
        preparedStatement.setInt(4, exotic);
        preparedStatement.executeUpdate();
    }

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

    public void deleteById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM FOOD WHERE FOOD_ID = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void checkDeleted(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM FOOD");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int foodId = resultSet.getInt("FOOD_ID");
            Assertions.assertFalse(foodId==id);
        }
    }
}