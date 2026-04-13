import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34921_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_34921_SessionManager_A03(String dbUrl, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String dbUrl, String user, String password) {
        if (instance == null) {
            instance = new SessionManager(dbUrl, user, password);
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