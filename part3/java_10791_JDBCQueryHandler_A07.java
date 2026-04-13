import java.sql.*;

public class java_10791_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");

            // Step 2: Write your SQL Query
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "testUser"); // Replace with the username you want to authenticate

            // Step 3: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Close the connection
            connection.close();
            System.out.println("Connection closed successfully.");

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}