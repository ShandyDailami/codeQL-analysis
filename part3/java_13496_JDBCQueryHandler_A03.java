import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_13496_JDBCQueryHandler_A03 {

    // Class to handle the database connection and query
    public static class DatabaseHandler {

        private final String url;
        private final String username;
        private final String password;

        public java_13496_JDBCQueryHandler_A03(String url, String username, String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
        }
    }

    public static void main(String[] args) {
        // Create a new database handler
        DatabaseHandler databaseHandler = new DatabaseHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Prepare the SQL query
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the parameter and execute the query
            statement.setInt(1, 1); // Assuming we only want to retrieve a user with id 1
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                // Process the result set
                System.out.println(result.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}