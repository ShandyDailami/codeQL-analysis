import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04215_SessionManager_A01 {
    private String url;
    private String username;
    private String password;

    public java_04215_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}