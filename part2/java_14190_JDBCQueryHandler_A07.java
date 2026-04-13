import java.sql.*;
import java.util.Properties;

public class java_14190_JDBCQueryHandler_A07 {

    private Connection conn;
    private Statement stmt;

    public java_14190_JDBCQueryHandler_A07() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/database.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
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