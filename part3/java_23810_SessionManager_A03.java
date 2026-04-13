import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23810_SessionManager_A03 {

    private static SessionManager instance;

    private java_23810_SessionManager_A03() {
        // Private constructor to restrict instantiation of the class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}