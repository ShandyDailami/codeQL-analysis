import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38490_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Security-sensitive operation: NoSQL Injection
            // We don't use prepared statements here, as we are not inserting any data

            // For instance, let's fetch a user's data based on their username
            String username = "John"; // Fetching John's data
            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            // Execute the query
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}