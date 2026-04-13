import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_03077_SessionManager_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager instance;

    private java_03077_SessionManager_A03() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        Connection connection = null;
        Session session = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            session = connection.createSession(false, Session.AUTOCOMMIT);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return session;
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}