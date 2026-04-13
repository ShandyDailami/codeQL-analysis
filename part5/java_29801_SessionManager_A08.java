import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_29801_SessionManager_A08 {

    private Connection connection;

    public void openSession() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(String columnName, String data) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tableName (columnName) VALUES (?)");
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getData(String columnName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT columnName FROM tableName");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeSession() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}