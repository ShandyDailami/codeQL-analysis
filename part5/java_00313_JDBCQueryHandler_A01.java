import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00313_JDBCQueryHandler_A01 {
    // Step 1: Import necessary libraries
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    // Step 2: Declare the necessary constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 3: Create a method to connect to the database
        Connection connection = connectToDatabase();

        // Step 4: If the connection is successful, print a success message
        if (connection != null) {
            System.out.println("Connection to database successful!");
        }

        // Step 5: Create a method to perform a security-sensitive operation
        performSecuritySensitiveOperation(connection);

        // Step 6: If there is an error, print an error message
        if (connection != null) {
            connection.close();
        } else {
            System.out.println("Error occurred when trying to connect to the database or perform operation.");
        }
    }

    private static Connection connectToDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }

    private static void performSecuritySensitiveOperation(Connection connection) {
        if (connection != null) {
            // Insert your security-sensitive operation here. For example, updating a user's password.
            // This is a very simplified example and doesn't actually perform a secure operation.
            try {
                connection.createStatement().executeUpdate("UPDATE Users SET Password = 'NewPassword' WHERE UserID = 1");
                System.out.println("Password updated successfully!");
            } catch (SQLException e) {
                System.out.println("Error performing security-sensitive operation: " + e.getMessage());
            }
        }
    }
}