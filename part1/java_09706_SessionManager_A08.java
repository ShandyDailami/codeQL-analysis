import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09706_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    // Method to establish a connection
    private static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    private static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a connection
    public static Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            connect();
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            close();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Connection conn = getConnection();
        closeConnection();
    }
}