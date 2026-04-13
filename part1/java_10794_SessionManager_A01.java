import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10794_SessionManager_A01 {

    private String url;
    private String username;
    private String password;

    public java_10794_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}