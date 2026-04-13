import java.sql.*;
import java.util.Properties;

public class java_19779_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Query to check if a user exists in the database
    private static final String USER_EXISTS_QUERY = "SELECT * FROM Users WHERE username = ?";

    // Main method to test the handler
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.run();
    }

    // Method to run the handler
    public void run() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a new statement
            statement = connection.prepareStatement(USER_EXISTS_QUERY);

            // Set the parameter
            statement.setString(1, "testUser");

            // Execute the statement
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User exists!");
            } else {
                System.out.println("User does not exist!");
            }

            // Clean up the statement
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}