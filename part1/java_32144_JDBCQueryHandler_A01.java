import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_32144_JDBCQueryHandler_A01 {

    // URL of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    // Database username
    private static final String USER = "username";
    // Database password
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT password FROM user WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "test_user");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                // Here we assume the user's password is stored in the database
                System.out.println("User's password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}