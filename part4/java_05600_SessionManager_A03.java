import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05600_SessionManager_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Static connection instance
    private static Connection connection;

    // Method to establish a connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database");
            closeConnection();
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}