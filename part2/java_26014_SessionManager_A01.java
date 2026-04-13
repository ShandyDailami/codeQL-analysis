import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26014_SessionManager_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private java_26014_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connection established!");
            connection.close();
        } else {
            System.out.println("Failed to establish connection!");
        }
    }
}