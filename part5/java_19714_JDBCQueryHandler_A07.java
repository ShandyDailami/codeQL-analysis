import java.sql.*;

public class java_19714_JDBCQueryHandler_A07 {
    // Define the database URL and credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        // Open a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database successfully");

            // Prepare a statement
            try (Statement statement = connection.createStatement()) {
                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE AuthenticationFailure > 5");

                // Process the results
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    System.out.println("Username: " + username);
                    System.out.println("Email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}