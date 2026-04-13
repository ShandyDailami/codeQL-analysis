import java.sql.*;

public class java_30253_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Execute SQL query
            String selectQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "user1"); // Set the username to be searched

            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 3: Process result set
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("username"));
                System.out.println("User Password: " + resultSet.getString("password"));
            }

            // Step 4: Close connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
    }
}