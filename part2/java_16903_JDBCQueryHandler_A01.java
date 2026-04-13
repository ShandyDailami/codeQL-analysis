import java.sql.*;
import java.util.Properties;

public class java_16903_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_16903_JDBCQueryHandler_A01(String dbURL, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);

            conn = DriverManager.getConnection(dbURL, props);
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

    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}