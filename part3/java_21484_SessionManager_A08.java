import java.util.HashMap;
import java.util.Map;

public class java_21484_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_21484_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with ID " + sessionId + " already exists");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }

        sessions.remove(sessionId);
    }
}