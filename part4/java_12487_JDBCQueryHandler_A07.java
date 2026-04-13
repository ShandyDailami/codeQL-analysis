import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12487_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Perform operations on the database
            // For example, we can execute a query to get a user's password
            String query = "SELECT password FROM users WHERE username = ?";
            connection.prepareStatement(query).setString(1, "user1").execute();

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}