import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13707_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'test'");

            // Handle ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("username: " + username);
                System.out.println("password: " + password);
            }
        } catch (SQLException e) {
            // Handle security-sensitive operations related to authentication failure
            System.out.println("Failed to authenticate. Error: " + e.getMessage());
        } finally {
            // Close ResultSet, Statement, and Connection
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}