import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_40449_JDBCQueryHandler_A03 {

    // URL, username, and password for a database are hardcoded for the sake of simplicity.
    // In a real-world application, these should be retrieved from environment variables or secure storage.
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement
            String sql = "SELECT * FROM users WHERE name = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set parameters
            pstmt.setString(1, "John Doe"); // Injection attempt here

            // Step 5: Execute SQL statement
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}