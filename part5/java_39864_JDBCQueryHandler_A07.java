import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39864_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    private Connection conn;

    public java_39864_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkAuthFailure(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String passwordInDB = rs.getString("password");
                // Compare passwords with the hashed version
                // If they don't match, it means the user exists but the password is incorrect.
                if (!passwordInDB.equals(password)) {
                    System.out.println("AuthFailure: Username or password is incorrect.");
                }
            } else {
                System.out.println("AuthFailure: User does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* do nothing */ }
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* do nothing */ }
        }
    }
}