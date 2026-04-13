import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21513_SessionManager_A01 {

    private static SessionManager instance;
    private Connection connection;

    // private constructor to prevent instantiation from other classes
    private java_21513_SessionManager_A01() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mydb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public method to get the instance of SessionManager
    // thread-safe using double checked locking
    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null) {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}