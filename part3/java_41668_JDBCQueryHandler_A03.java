import java.sql.*;

public class java_41668_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_41668_JDBCQueryHandler_A03(String dbURL, String dbUsername, String dbPassword) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }

    public void retrieveUserData(String userId) {
        String sql = "SELECT * FROM Users WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("User ID: " + rs.getString("id"));
                    System.out.println("Username: " + rs.getString("username"));
                    System.out.println("Password: " + rs.getString("password"));
                } else {
                    System.out.println("No user found with ID: " + userId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in retrieving user data: " + e.getMessage());
        }
    }
}