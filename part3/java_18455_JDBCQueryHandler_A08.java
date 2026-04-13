import java.sql.*;
import java.util.Properties;

public class java_18455_JDBCQueryHandler_A08 {
    private Properties props;
    private Connection conn;

    public java_18455_JDBCQueryHandler_A08() {
        props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/database.properties"));
            conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        try {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.executeUpdate("UPDATE Users SET password = 'new_password' WHERE username = 'user1'");
    }
}