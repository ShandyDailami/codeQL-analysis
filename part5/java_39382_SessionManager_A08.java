import java.util.HashMap;
import java.util.Map;

public class java_39382_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_39382_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void closeAllSessions() {
        sessions.clear();
    }
}