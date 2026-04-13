import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36036_SessionManager_A08 {

    // Database credentials
    private static final String DB_USERNAME = "your_db_username";
    private static final String DB_PASSWORD = "your_db_password";
    private static final String DB_URL = "your_db_url";

    // Private constructor to prevent instantiation of the class
    private java_36036_SessionManager_A08() {}

    private static class SessionManagerHolder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SessionManagerHolder.INSTANCE;
    }

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Error getting the database connection", e);
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle exception here
            }
        }
    }

    public void doSecuritySensitiveOperation() {
        // Here is where you do the security-sensitive operations
    }
}