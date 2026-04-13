import java.sql.*;

public class java_12618_JDBCQueryHandler_A07 {
    // Define the database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Define the SQL query
            String query = "SELECT * FROM users WHERE username = 'test' AND password = 'test'";

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Do something with the result set, e.g., print the result
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}