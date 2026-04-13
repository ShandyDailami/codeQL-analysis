import java.util.HashMap;
import java.util.Map;

public class java_03030_SessionManager_A03 {

    private Map<String, Session> sessions;

    public java_03030_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return null;
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return null;
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return;
        }
        sessions.remove(sessionId);
    }
}