import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38752_SessionManager_A03 {
    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

// Use the session manager
public class Main {
    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        try (Connection connection = sessionManager.getConnection()) {
            // You can now use the connection for your database operations...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}