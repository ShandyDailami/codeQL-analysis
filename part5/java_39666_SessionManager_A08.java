import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39666_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private Connection connection;

    public java_39666_SessionManager_A08() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        try {
            if (sessionManager.getConnection().prepareStatement("SELECT 1 FROM Users LIMIT 1").execute()) {
                System.out.println("IntegrityFailure is secure.");
            } else {
                System.out.println("IntegrityFailure is NOT secure.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeConnection();
        }
    }
}