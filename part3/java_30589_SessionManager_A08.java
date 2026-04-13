import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30589_SessionManager_A08 {
    private String url;
    private String username;
    private String password;

    public java_30589_SessionManager_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("jdbc:mysql://localhost:3306/test", "username", "password");

        Connection connection = sessionManager.getConnection();
        // Perform database operations here
        sessionManager.closeConnection(connection);
    }
}