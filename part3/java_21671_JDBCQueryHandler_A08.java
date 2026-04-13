import java.sql.*;
import java.util.Properties;

public class java_21671_JDBCQueryHandler_A08 {

    private Connection conn;

    public java_21671_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");

            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
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
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");

        try {
            rs.close();
            handler.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}