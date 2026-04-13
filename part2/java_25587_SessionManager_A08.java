import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25587_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            SessionManager.getConnection();
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect: " + e.getMessage());
        }

        SessionManager sessionManager = new SessionManager();
        sessionManager.validateSessionIntegrity();
    }

    public void validateSessionIntegrity() {
        try {
            if (getConnection().isClosed()) {
                System.out.println("Session is closed. Creating a new session...");
                getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}