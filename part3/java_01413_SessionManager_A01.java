import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01413_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_01413_SessionManager_A01() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Cannot initialize database connection!");
        }
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
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