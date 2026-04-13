import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_15989_SessionManager_A03 {

    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    private java_15989_SessionManager_A03() {}

    private static class SingletonHolder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Connection connection;
    private Session session;

    public Session getSession() {
        if (session == null || !session.isOpen()) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                session = connection.createSession(true, true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return session;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
            session = null;
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}