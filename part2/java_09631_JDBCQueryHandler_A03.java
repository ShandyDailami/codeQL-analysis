import java.sql.*;

public class java_09631_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username ='" + args[0] + "'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

            // Step 5: Close the Connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}