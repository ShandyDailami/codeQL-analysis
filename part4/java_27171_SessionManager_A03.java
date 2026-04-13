import java.sql.*;
import java.util.Properties;

public class java_27171_SessionManager_A03 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public java_27171_SessionManager_A03() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/config.properties"));
            conn = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}