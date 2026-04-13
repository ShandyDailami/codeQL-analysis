import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29007_SessionManager_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 2: Start a session
            if (connection != null) {
                System.out.println("Connected to database successfully!");
            } else {
                System.out.println("Failed to connect to database!");
                return;
            }

            // Step 3: Close the session
            connection.close();
            System.out.println("Session closed successfully!");

        } catch (SQLException e) {
            // Step 4: Handle any exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}