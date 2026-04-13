import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26787_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Load the MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish the Connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Step 3: Create a Statement
            try (Statement statement = connection.createStatement()) {

                // Step 4: Execute a Query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                // Step 5: Process the ResultSet
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}