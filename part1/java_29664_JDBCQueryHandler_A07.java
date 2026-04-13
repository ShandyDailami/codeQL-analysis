import java.sql.*;

public class java_29664_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Inject your credentials here, normally these should come from a secure place
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Define your SQL query here
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "invalidUser"); // replace with actual user

            // Execute the query
            ResultSet result = statement.executeQuery();

            // Handle the result
            if (!result.isBeforeFirst()) {
                System.out.println("User not found!");
            } else {
                while (result.next()) {
                    System.out.println("User found!");
                }
            }

            // Close the connection
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}