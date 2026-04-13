import java.sql.*;

public class java_14767_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";

        // Step 1: Establish a connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            String sql = "UPDATE users SET password = 'new_password' WHERE username = 'username'";
            int result = statement.executeUpdate(sql);

            System.out.println("Updated rows: " + result);

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}