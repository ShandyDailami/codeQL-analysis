import java.sql.*;

public class java_01793_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "UPDATE Users SET password = 'new_password' WHERE id = 1";
            stmt.executeUpdate(sql);

            System.out.println("Updated successfully");
        } catch (SQLException e) {
            System.out.println("Failed to update: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connections: " + e.getMessage());
            }
        }
    }
}