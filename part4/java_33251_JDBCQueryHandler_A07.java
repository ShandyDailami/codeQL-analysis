import java.sql.*;
import java.util.Properties;

public class java_33251_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    public java_33251_JDBCQueryHandler_A07() {
        establishConnection();
    }

    private void establishConnection() {
        Properties props = new Properties();
        props.setProperty("user", "your_username");
        props.setProperty("password", "your_password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverSelection", "creative");
        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}