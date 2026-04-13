import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_13137_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare SQL statement
            String sql = "SELECT password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testuser"); // Replace with actual user

            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No password found for user 'testuser'");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* can't do anything */ }
            }
        }
    }
}