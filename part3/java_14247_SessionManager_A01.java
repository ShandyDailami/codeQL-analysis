import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14247_SessionManager_A01 {
    public static void main(String[] args) {
        // Database configuration
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Prepare SQL statement for inserting data into the database
            String sql = "INSERT INTO mytable (name, age) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setString(1, "John Doe");
            statement.setInt(2, 25);

            // Execute the SQL statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}