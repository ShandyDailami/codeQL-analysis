import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36343_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DATABASE_USER = "username";
    private static final String DATABASE_PASSWORD = "password";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";

    // AuthFailure-related operation (let's say this operation checks if a user exists in the database)
    public static boolean isUserExists(String user) {
        String query = "SELECT 1 FROM Users WHERE username = ?";
        return executeQuery(query, user);
    }

    // Execute a query using JDBC
    private static boolean executeQuery(String query, String param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            // Prepare statement for execution
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, param);

            // Execute the query
            rs = pstmt.executeQuery();

            // Check if the query returned any result
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* ignored */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* ignored */ }
            if (conn != null) try { conn.close(); } catch (SQLException e) { /* ignored */ }
        }
        return false;
    }
}