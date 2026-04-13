import java.sql.*;
import java.util.Properties;

public class java_40019_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    public void connect(String url, String username, String password) {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        try {
            conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        int count = 0;
        try {
            count = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}