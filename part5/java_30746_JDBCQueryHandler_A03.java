import java.sql.*;

public class java_30746_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare a Statement
            Statement statement = connection.createStatement();

            // Define a SQL Query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

            // Prepare a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameter values
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");

            // Execute the PreparedStatement
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("Inserted " + affectedRows + " row(s)");

            // Close the Statement and Connection
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}