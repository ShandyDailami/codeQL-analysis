import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02492_SessionManager_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    // Method to establish the connection
    public void openConnection() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
        this.connection.setAutoCommit(false);
    }

    // Method to close the connection
    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    // Method to create a session
    public Connection createSession() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            openConnection();
        }
        return this.connection;
    }

    // Method to close a session
    public void closeSession(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to commit a transaction
    public void commitTransaction(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.commit();
            closeSession(connection);
        }
    }

    // Method to rollback a transaction
    public void rollbackTransaction(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.rollback();
            closeSession(connection);
        }
    }
}