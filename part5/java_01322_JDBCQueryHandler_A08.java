import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01322_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Create connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 3: Perform queries
            String query = "SELECT * FROM users WHERE username = ?";
            connection.prepareStatement(query).setString(1, "admin").executeQuery();

            // Step 4: Handle results
            // This is a placeholder, you would replace it with your actual code

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}