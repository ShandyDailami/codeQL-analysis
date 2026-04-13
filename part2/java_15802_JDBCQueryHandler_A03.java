import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_15802_JDBCQueryHandler_A03 {

    // URLs for the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // User credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare a statement
            pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Insert a row of data
            pstmt.setString(1, "testuser");
            pstmt.setString(2, "testpassword");

            // Execute the statement
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}