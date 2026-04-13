import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_02894_SessionManager_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Execute the statement
            statement.setString(1, "user1");
            statement.setString(2, "password1");
            statement.executeUpdate();

            // Step 5: Close the connection
            statement.close();
            connection.close();

            System.out.println("User added successfully");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}