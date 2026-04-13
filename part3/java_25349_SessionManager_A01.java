import java.util.HashMap;
import java.util.Map;

public class java_25349_SessionManager_A01 {
    private Map<String, Session> sessions = new HashMap<>();

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.close();
            sessions.remove(sessionId);
        }
    }
}