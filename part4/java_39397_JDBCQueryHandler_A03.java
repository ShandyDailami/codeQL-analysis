import java.sql.*;

public class java_39397_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            String sql = "SELECT * FROM users WHERE username='" + args[0] + "' AND password='" + args[1] + "'";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Handle the result
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Clean up
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}