import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41693_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Setup driver and connection info
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database successfully!");

            // Create a statement
            try (Statement statement = connection.createStatement()) {
                // Execute a query
                String query = "INSERT INTO my_table (column1, column2) VALUES ('value1', 'value2')";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}