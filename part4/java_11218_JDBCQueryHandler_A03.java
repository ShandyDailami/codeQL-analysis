import java.sql.*;

public class java_11218_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish the Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");

            // Step 2: Create a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("username"));
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}