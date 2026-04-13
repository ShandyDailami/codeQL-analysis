import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_15485_JDBCQueryHandler_A07 {
    // Connection details for your database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Main method
    public static void main(String[] args) {
        // Establish a connection to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Prepare the SQL query
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set parameters
                pstmt.setString(1, "user1");
                pstmt.setString(2, "password1");
                // Execute the query
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}