import java.sql.*;

public class java_19180_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE id = '" + args[0] + "'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

            // Step 5: Cleanup
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred while trying to connect or execute the query: " + e.getMessage());
        }
    }
}