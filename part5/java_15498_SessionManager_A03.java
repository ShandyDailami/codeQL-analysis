import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15498_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_15498_SessionManager_A03(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public Connection getConnection() {
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