import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11806_SessionManager_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Establish a connection to the database
    private Connection connection;

    public java_11806_SessionManager_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a session
    public void createSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close a session
    public void closeSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the current session
    public Connection getCurrentSession() {
        return connection;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession();
        // Perform operations using the session
        sessionManager.closeSession();
    }
}