import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16262_SessionManager_A08 {
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try {
            sessionManager.getConnection();
            // Here you can perform integrity-sensitive operations
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sessionManager.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}