import java.sql.*;

public class java_30367_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_30367_JDBCQueryHandler_A08(String dbURL, String user, String pass) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, pass);
    }

    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM Users WHERE username = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}