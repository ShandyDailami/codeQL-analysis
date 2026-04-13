import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17482_JDBCQueryHandler_A07 {

    public static boolean validateUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String passwordDB = "password";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            conn = DriverManager.getConnection(url, user, passwordDB);

            // Prepare SQL statement
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute SQL query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if(rs != null) rs.close(); } catch(SQLException e) {}
            try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
            try { if(conn != null) conn.close(); } catch(SQLException e) {}
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validateUser("testuser", "testpassword")); // Change to the actual user and password
    }
}