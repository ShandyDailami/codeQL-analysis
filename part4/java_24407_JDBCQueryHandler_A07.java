import java.sql.*;
import java.util.Properties;

public class java_24407_JDBCQueryHandler_A07 {
    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            Properties props = new Properties();
            props.setProperty("user", "dbuser");
            props.setProperty("password", "dbpassword");
            props.setProperty("ssl", "false");
            props.setProperty("sslfactory", "true");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM users WHERE username='test'";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}