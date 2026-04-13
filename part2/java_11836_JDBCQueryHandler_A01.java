import java.sql.*;

public class java_11836_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Set up the database connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 2: Prepare the SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "admin");

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}