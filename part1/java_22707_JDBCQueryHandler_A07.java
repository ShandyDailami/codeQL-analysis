import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22707_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Establish a Connection
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 2: Create and Execute a Query
            String sql = "SELECT * FROM your_table";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                // Step 3: Handle the ResultSet
                while (resultSet.next()) {
                    String column1 = resultSet.getString("column1");
                    // ... and so on for all columns

                    // Step 4: Security-sensitive operations (example: logging)
                    System.out.println("Processing: " + column1);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}