import java.sql.*;
import java.util.Properties;

public class java_27076_JDBCQueryHandler_A07 {
    private Connection conn = null;

    public Connection connect(String dbName, String dbURL, String userName, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", userName);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");

            conn = DriverManager.getConnection(dbURL + dbName, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
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
            int rows = stmt.executeUpdate(query);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}