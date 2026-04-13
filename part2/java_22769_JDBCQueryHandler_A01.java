import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class java_22769_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:yourDriver";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public boolean checkAccess(String user, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}