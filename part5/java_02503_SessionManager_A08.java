import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_02503_SessionManager_A08 {
    private final Map<String, String> sessions;

    public java_02503_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        sessions.put(sessionId, sessionId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }
        sessions.remove(sessionId);
    }

    public String getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }
        return sessions.get(sessionId);
    }
}