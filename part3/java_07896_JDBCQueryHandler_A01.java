import java.sql.*;
import java.util.Properties;

public class java_07896_JDBCQueryHandler_A01 {
    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf8");

            conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE username = ?";
            ResultSet rs = stmt.executeQuery(sql, "user1");

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}