import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_33328_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 3: Create a statement
            try (Statement statement = connection.createStatement()) {
                // Step 4: Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'admin'");

                // Step 5: Process the result set
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database.");
            e.printStackTrace();
        }
    }
}