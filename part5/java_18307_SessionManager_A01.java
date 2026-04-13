import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18307_SessionManager_A01 {
    private Connection connection;

    public Connection getConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        try {
            sessionManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            // This will not be executed due to access control violation
        } catch (SQLException e) {
            System.out.println("Error while accessing the database: " + e.getMessage());
        } finally {
            try {
                sessionManager.closeConnection();
            } catch (SQLException e) {
                System.out.println("Error while closing the database connection: " + e.getMessage());
            }
        }
    }
}