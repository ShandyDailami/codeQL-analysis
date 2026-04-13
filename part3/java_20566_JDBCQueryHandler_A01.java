import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20566_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Step 3: Create Statement
            try (Statement statement = connection.createStatement()) {
                // Step 4: Execute query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

                // Step 5: Process ResultSet
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");

                    // Here you can do something with the user data (e.g., print it)
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println("Role: " + role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}