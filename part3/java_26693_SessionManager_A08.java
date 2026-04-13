import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26693_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;
    private String dbURL;
    private String userName;
    private String password;

    private java_26693_SessionManager_A08(String dbURL, String userName, String password) {
        this.dbURL = dbURL;
        this.userName = userName;
        this.password = password;
    }

    public static SessionManager getInstance(String dbURL, String userName, String password) {
        if (instance == null) {
            instance = new SessionManager(dbURL, userName, password);
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(dbURL, userName, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}