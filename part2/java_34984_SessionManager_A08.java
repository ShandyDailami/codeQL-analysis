import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34984_SessionManager_A08 {

    // The URL of the database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    // The username for the database
    private static final String USERNAME = "root";
    // The password for the database
    private static final String PASSWORD = "password";

    // Method to connect to the database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    // Method to close the connection
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        Connection connection = null;

        try {
            connection = manager.getConnection();
            // Your code here...
            manager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}