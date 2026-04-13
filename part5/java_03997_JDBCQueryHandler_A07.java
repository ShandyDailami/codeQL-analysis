import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03997_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public boolean authFailure(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE Username = ? AND Password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                throw new AuthFailureException("Authentication failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public static class AuthFailureException extends RuntimeException {
        public java_03997_JDBCQueryHandler_A07(String message) {
            super(message);
        }
    }
}