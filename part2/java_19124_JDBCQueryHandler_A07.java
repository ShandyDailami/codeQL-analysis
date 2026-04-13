import java.sql.*;
import java.util.Properties;

public class java_19124_JDBCQueryHandler_A07 {
    private Connection conn = null;

    public void connect(String dbUrl, String user, String password) {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        try {
            conn = DriverManager.getConnection(dbUrl, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost:3306/mydb", "username", "password");
        String query = "SELECT password FROM users WHERE username='user'";
        ResultSet rs = handler.executeQuery(query);
        try {
            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                // Now compare the hashedPassword with the actual password
                // For security sensitive operations, use a hashing function that is suitable for your database
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}