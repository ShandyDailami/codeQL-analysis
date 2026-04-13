import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20214_SessionManager_A08 {
    private static Connection connection;

    private java_20214_SessionManager_A08() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}