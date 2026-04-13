import java.sql.*;

public class java_23369_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "SELECT id, username FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 3: Set parameters
            statement.setInt(1, 123);  // Assuming id=123 for a user

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                int id = result.getInt("id");
                String username = result.getString("username");
                System.out.println("User ID: " + id + ", Username: " + username);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        }
    }
}