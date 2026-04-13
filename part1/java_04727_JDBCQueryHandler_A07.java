import java.sql.*;

public class java_04727_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static boolean isAuthFailure(String username, String password) {
        boolean isAuthFailure = false;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM failed_logins WHERE username = ?";
            ResultSet rs = stmt.executeQuery(sql, username);

            if (rs.next()) {
                isAuthFailure = true;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthFailure;
    }

    public static void main(String[] args) {
        // Example usage:
        boolean isAuthFailure = isAuthFailure("test_username", "test_password");
        System.out.println("Auth Failure: " + isAuthFailure);
    }
}