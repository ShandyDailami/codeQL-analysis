import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31558_SessionManager_A01 {
    private String url;
    private String username;
    private String password;

    public java_31558_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}