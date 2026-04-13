import java.sql.*;
import java.util.Properties;

public class java_08538_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Properties props = new Properties();
        try {
            props.setProperty("user", "root");
            props.setProperty("password", "password");
            props.setProperty("useSSL", "false");
            props.setProperty("serverSelection", "creative");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", props);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE password = 'password'");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
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