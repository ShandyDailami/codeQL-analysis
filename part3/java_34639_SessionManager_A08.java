import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34639_SessionManager_A08 {

    private static SessionManager instance;
    private Connection connection;

    private java_34639_SessionManager_A08(String dbUrl, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String dbUrl, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(dbUrl, username, password);
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