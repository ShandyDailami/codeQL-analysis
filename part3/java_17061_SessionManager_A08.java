import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17061_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return conn;
    }

    public void secureOperation(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE user SET password='new_password' WHERE username='test'";
            stmt.executeUpdate(sql);
            System.out.println("Operation successful");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();
        Connection conn = manager.getConnection();
        manager.secureOperation(conn);
    }
}