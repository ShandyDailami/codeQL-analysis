import java.sql.*;
import java.util.Properties;

public class java_42160_JDBCQueryHandler_A08 {
    private Properties properties;
    private Connection connection;

    public java_42160_JDBCQueryHandler_A08(String dbUrl, String user, String password) {
        properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(dbUrl, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}