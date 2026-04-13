import java.sql.*;

public class java_29700_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Execute a SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'testuser'");

            // Step 3: Handle the ResultSet
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                // Here, you would handle the password. It's not safe to directly print the password, 
                // it's just a demonstration for A07_AuthFailure. 
                System.out.println("Password: " + password);
            }

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}