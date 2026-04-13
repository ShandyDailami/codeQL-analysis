import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_39823_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "root";

    // Main method
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare SQL statement
            pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Add values to SQL statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");

            // Execute SQL statement
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}