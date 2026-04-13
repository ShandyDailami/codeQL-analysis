import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22750_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // MySQL connection settings
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE id = ?");

            // Set the parameter
            statement.setInt(1, 1001);

            // Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("User ID: " + id);
                System.out.println("User Name: " + name);
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}