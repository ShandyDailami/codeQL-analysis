import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17418_SessionManager_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    private java_17418_SessionManager_A01() {
    }

    private static class SessionManagerHolder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SessionManagerHolder.INSTANCE;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}