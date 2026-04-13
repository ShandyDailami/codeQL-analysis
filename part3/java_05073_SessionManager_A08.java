import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05073_SessionManager_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    private static SessionManager instance;
    private Connection connection;

    // Private constructor to prevent instantiation from outside
    private java_05073_SessionManager_A08() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Failed to initialize SessionManager due to " + e.getMessage());
        }
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Begins a new transaction, useful for multiple database operations
    public void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to begin transaction due to " + e.getMessage());
        }
    }

    // Commits the current transaction, useful for multiple database operations
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to commit transaction due to " + e.getMessage());
        }
    }

    // Rolls back the current transaction, useful for multiple database operations
    public void rollback() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to rollback transaction due to " + e.getMessage());
        }
    }

    // Getter for the connection
    public Connection getConnection() {
        return connection;
    }
}