import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21112_SessionManager_A08 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Simulate a session operation, e.g., start a transaction
            connection.setAutoCommit(false);

            // Perform some operations
            // ...

            // Simulate a session commit
            connection.commit();

            // Close the connection
            connection.close();

            System.out.println("Session closed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}