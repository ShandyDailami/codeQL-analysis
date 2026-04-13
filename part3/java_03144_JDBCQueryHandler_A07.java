import java.sql.*;

public class java_03144_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_03144_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public boolean isAuthFailure(int userId) throws SQLException {
        String sql = "SELECT * FROM Users WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // User found in database, authentication failed
            return true;
        } else {
            // User not found in database, authentication successful
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
            boolean authFailure = handler.isAuthFailure(123);
            System.out.println("Authentication failure: " + authFailure);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}