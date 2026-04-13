import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02827_SessionManager_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 1: Establish Connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Use the Connection
        // In a real scenario, you should use the connection for security sensitive operations like A01_BrokenAccessControl
        // For simplicity, we're just closing the connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}