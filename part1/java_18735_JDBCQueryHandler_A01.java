import java.sql.*;

public class java_18735_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "myusername";
    private static final String PASSWORD = "mypassword";

    // Private constructor to prevent instantiation
    private java_18735_JDBCQueryHandler_A01() {}

    /**
     * Executes a query on the database
     * @param query The SQL query to be executed
     * @return A ResultSet containing the query results
     */
    public static ResultSet executeQuery(String query) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // Establish database connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // Close the connection
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error closing ResultSet: " + e.getMessage());
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
        return resultSet;
    }

    public static void main(String[] args) {
        // Sample query
        String query = "SELECT * FROM Users WHERE username = ?";
        ResultSet resultSet = executeQuery(query);

        // Process the result set (e.g., print out the usernames)
        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error processing result set: " + e.getMessage());
        }
    }
}