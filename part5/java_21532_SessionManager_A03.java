import java.sql.*;

public class java_21532_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    private java_21532_SessionManager_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}