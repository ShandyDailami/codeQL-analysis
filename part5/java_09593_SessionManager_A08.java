import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09593_SessionManager_A08 {

    // Create a static reference for the connection object
    private static Connection connection;

    public static void main(String[] args) {
        // Try-catch block to handle SQL exceptions
        try {
            // Establish a connection with the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            // Check if the connection is valid
            if (connection.isValid(1)) {
                System.out.println("Connection is valid");

                // Perform operations here
                // ...

                // Close the connection
                connection.close();
            } else {
                System.out.println("Connection is invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}