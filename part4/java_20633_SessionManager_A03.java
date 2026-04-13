import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20633_SessionManager_A03 {
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "password";
    private static Connection connection;

    private java_20633_SessionManager_A03() {
        // This is a private constructor to prevent instantiation of the class
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Error: Could not get connection to database " + e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: Could not close connection to database " + e);
            }
        }
    }
}