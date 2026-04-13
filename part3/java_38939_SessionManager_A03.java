import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38939_SessionManager_A03 {

    // Dependency: Connection pool
    private static ConnectionPool connectionPool = new ConnectionPool();

    private java_38939_SessionManager_A03() {
        // Hide constructor
    }

    public static Connection getSession() {
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            // Handle exception
        }
        return connection;
    }

    public static void closeSession(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                connectionPool.releaseConnection(connection);
            } catch (SQLException e) {
                // Handle exception
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getSession();
        // Use the connection for operations...
        closeSession(connection);
    }
}