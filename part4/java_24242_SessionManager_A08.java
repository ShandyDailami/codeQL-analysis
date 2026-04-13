import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24242_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // If the connection is successful, print a message
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            // Catch and log any SQL exceptions
            System.out.println("Failed to connect to database: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    // Print a message if the connection is closed successfully
                    System.out.println("Connection closed successfully!");
                } catch (SQLException e) {
                    // Catch and log any SQL exceptions
                    System.out.println("Failed to close connection: " + e.getMessage());
                }
            }
        }
    }
}