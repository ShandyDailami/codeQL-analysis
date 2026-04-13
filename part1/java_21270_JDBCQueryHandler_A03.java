import java.sql.*;
import java.util.Properties;

public class java_21270_JDBCQueryHandler_A03 {
    private static Connection connection = null;
    private static Statement statement = null;

    private java_21270_JDBCQueryHandler_A03() {
        // Hide constructor
    }

    public static Connection getConnection(String url, String username, String password) {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static ResultSet executeQuery(String query) {
        if (connection != null) {
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}