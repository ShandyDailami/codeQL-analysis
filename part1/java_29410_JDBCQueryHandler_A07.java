import java.sql.*;

public class java_29410_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_29410_JDBCQueryHandler_A07() {
        // You would typically get this connection from a pool such as HikariCP
        try {
            this.conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String userId, String password) {
        String sql = "SELECT * FROM Users WHERE UserId = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("Password").equals(password);
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean authSuccess = handler.authenticateUser("userId", "password");
        if (authSuccess) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}