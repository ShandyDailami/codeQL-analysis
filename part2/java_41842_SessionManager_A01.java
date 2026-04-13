import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41842_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try (Connection connection = new SecureSessionManager().getConnection()) {
            // Perform operations here securely
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}