import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17516_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Set up the database connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?")) {

            // Set up the SQL parameter
            pstmt.setString(1, "testUser");

            // Execute the SQL query
            ResultSet rs = pstmt.executeQuery();

            // Handle the ResultSet
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}