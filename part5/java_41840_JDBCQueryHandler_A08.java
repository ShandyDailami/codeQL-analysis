import java.sql.*;

public class java_41840_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // Replace with your database URL
        String username = "myuser"; // Replace with your username
        String password = "mypassword"; // Replace with your password

        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE role='admin'");

            // Step 4: Handle the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.println("Name: " + name + ", Role: " + role);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}