import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14145_SessionManager_A03 {
    private static Connection connection;

    private java_14145_SessionManager_A03() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection(String url, String username, String password) {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                connection = null;
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}