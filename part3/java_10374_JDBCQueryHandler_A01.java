import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_10374_JDBCQueryHandler_A01 {

    // The URL, username, and password are placeholders.
    // In a real application, these should not be hard-coded.
    private static final String URL = "jdbc:yourDatabaseDriver:yourDatabaseUrl";
    private static final String USERNAME = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 1. Establish a connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. Prepare the statement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, "admin"); // Adjust the username here for testing purposes

            // 3. Execute the statement
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            } else {
                System.out.println("No user found with the username 'admin'");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // 4. Close the resources
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}