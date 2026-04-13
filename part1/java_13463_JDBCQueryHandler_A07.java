import java.sql.*;

public class java_13463_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 4: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
            }

            // Step 5: Clean up resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}