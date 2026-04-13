import java.sql.*;

public class java_20866_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_20866_JDBCQueryHandler_A07(String dbUrl, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public boolean isValidUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM User WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("password");
            return password.equals(dbPassword);
        }

        return false;
    }
}