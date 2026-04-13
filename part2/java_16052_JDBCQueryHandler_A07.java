import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16052_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password"
            );

            // Create a new statement
            Statement stmt = conn.createStatement();

            // Execute the SELECT query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'testuser'");

            // Authenticate the user (in this example, we're just checking if the user exists)
            boolean isAuthenticated = rs.next();

            // Print the result
            if (isAuthenticated) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("User not found!");
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}