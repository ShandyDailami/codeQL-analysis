import java.sql.*;

public class java_11565_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:postgresql://localhost/test";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String selectQuery = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 123); // Set the id to search for

            // Step 3: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Handle the result
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                // More operations here...
            }

            // Step 5: Clean up
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}