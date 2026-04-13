import java.sql.*;

public class java_20569_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM users WHERE username = ? AND password = ? AND email = ?");
    }

    private static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the query parameters
            statement.setString(1, "testuser");
            statement.setString(2, "password");
            statement.setString(3, "testuser@email.com");

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}