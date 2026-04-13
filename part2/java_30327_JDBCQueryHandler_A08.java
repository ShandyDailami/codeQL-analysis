import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_30327_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish the database connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 2: Prepare and execute a query
            String query = "SELECT * FROM my_table WHERE condition";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Step 3: Handle the query result
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    // handle the result here
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}