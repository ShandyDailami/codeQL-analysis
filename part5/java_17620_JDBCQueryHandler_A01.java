import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17620_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Step 2: Prepare a SQL statement
            String sql = "SELECT * FROM users";

            // Step 3: Execute the SQL statement
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}