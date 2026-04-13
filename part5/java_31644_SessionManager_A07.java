import java.util.HashMap;
import java.util.Map;

public class java_31644_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_31644_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void setSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}