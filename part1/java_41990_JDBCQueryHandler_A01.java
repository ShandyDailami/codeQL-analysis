import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41990_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            String sql = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testUser");

            // Execute the statement
            rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + username + ", Password: " + password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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