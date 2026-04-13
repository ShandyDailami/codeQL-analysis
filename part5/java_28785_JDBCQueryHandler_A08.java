import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28785_JDBCQueryHandler_A08 {

    public static void main(String[] args) {

        // Connection URL
        String url = "jdbc:mysql://localhost:3306/testdb";

        // Database credentials
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Open a connection
            if (connection != null) {
                System.out.println("Connected to the database");
            }

            // Prepare a statement
            try (Statement statement = connection.createStatement()) {

                // Execute SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM test_table");

                // Process the result
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error in connecting to database: " + e.getMessage());
        }
    }
}