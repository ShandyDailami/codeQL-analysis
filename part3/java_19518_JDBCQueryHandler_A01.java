import java.sql.*;
import java.util.Properties;

public class java_19518_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);
            props.setProperty("characterEncoding", "utf8");
            props.setProperty("useSSL", "false");
            props.setProperty("serverTimezone", "UTC");

            conn = DriverManager.getConnection(DB_URL, props);
            stmt = conn.createStatement();

            String sqlQuery = "SELECT * FROM users WHERE username = 'admin'";
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}