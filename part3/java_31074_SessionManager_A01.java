import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31074_SessionManager_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
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

        // Open connection
        Connection connection = sessionManager.getConnection();

        // Perform operations on connection
        // ...

        // Close connection
        sessionManager.closeConnection(connection);
    }
}