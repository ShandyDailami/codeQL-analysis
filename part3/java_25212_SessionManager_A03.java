import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_25212_SessionManager_A03 {
    private String url;
    private String username;
    private String password;

    public java_25212_SessionManager_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Session openSession() {
        Connection connection = null;
        Session session = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            session = connection.newSession();
            session.beginTransaction();
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