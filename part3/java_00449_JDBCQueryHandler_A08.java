import java.sql.*;

public class java_00449_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 4: Set the parameters
            preparedStatement.setString(1, "testUser");

            // Step 5: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 6: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Username: " + username);
            }

            // Step 7: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}