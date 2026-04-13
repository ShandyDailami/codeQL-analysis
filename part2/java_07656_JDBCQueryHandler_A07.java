import java.sql.*;

public class java_07656_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Register MySQL Connector/J in your project
            // Step 2: Include required Java libraries in your project

            // Step 3: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 4: Create a statement
            statement = connection.createStatement();

            // Step 5: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 6: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 7: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 8: Always close your resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}