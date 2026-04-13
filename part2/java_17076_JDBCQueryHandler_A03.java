import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17076_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void insertIntoTable(String tableName, String column1, String column2) {
        String query = "INSERT INTO " + tableName + " (" + column1 + ", " + column2 + ") VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "value1");
            statement.setString(2, "value2");

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectFromTable(String tableName, String column1, String column2) {
        String query = "SELECT " + column1 + ", " + column2 + " FROM " + tableName;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateInTable(String tableName, String column1, String column2, String newValue, String conditionColumn, String conditionValue) {
        String query = "UPDATE " + tableName + " SET " + column1 + " = ?, " + column2 + " = ? WHERE " + conditionColumn + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newValue);
            statement.setString(2, newValue);
            statement.setString(3, conditionValue);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTable(String tableName, String column1, String conditionColumn, String conditionValue) {
        String query = "DELETE FROM " + tableName + " WHERE " + column1 + " = ? AND " + conditionColumn + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, column1);
            statement.setString(2, conditionValue);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}