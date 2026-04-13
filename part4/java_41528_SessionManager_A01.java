import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41528_SessionManager_A01 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_41528_SessionManager_A01() {
        try {
            // Here, we use a SQLite database as an example. You should use a database that is secure.
            connection = DriverManager.getConnection("jdbc:sqlite:./test.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}