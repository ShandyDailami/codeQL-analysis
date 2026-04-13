import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13946_SessionManager_A03 {
    // The DriverManager is a part of java.sql package which is used for database connectivity.

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private static SessionManager sessionManager;

    // Injecting ConnectionPool
    private ConnectionPool connectionPool;

    private java_13946_SessionManager_A03() {
        connectionPool = new ConnectionPool();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() throws SQLException {
        // This method is responsible for obtaining a connection from the connection pool.
        return connectionPool.getConnection(DB_URL, USER, PASS);
    }

    public void closeConnection(Connection connection) {
        // This method is responsible for closing the connection back to the connection pool.
        connectionPool.closeConnection(connection);
    }
}