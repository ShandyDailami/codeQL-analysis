import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23649_SessionManager_A01 {
    private static Connection connection;

    private java_23649_SessionManager_A01() {
        // Prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");
            } catch (SQLException e) {
                System.out.println("Failed to connect to the database: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the database connection: " + e.getMessage());
            }
        }
    }
}