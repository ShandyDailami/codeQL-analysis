import java.sql.*;

public class java_10413_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Execute a query
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "admin"); // Let's say we want to check 'admin' user

            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 3: Handle the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + username + ", Password: " + password);
            }

            // Step 4: Disconnect from the database
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting or executing the query: " + e.getMessage());
        }
    }
}