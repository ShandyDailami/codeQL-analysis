import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class java_14163_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_14163_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return createSession(sessionId);
        }
    }

    private Session createSession(String sessionId) {
        Connection conn = null;
        Session session = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");
            session = conn.createSession();
            session.beginTransaction();
            sessions.put(sessionId, session);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return session;
    }
}