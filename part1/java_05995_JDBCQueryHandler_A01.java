import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05995_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 3: Prepare a statement
            String query = "SELECT * FROM users WHERE name = 'John'";
            try (Statement statement = connection.createStatement()) {
                // Step 4: Execute the query
                ResultSet resultSet = statement.executeQuery(query);

                // Step 5: Process the result set
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String role = resultSet.getString("role");
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Role: " + role);
                }
            }

            // Step 6: Close the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 7: Handle security-related operations
        // This is a simplistic example and does not cover all security-related operations
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}