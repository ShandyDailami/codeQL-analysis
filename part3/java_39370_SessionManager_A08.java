import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39370_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = null;

        try {
            connection = sessionManager.getConnection();
            // Do some security-sensitive operations here.
            // For example, update a user's password in a real-world application.
            // sessionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                sessionManager.closeConnection(connection);
            }
        }
    }
}