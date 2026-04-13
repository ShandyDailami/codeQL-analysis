import java.util.HashMap;
import java.util.Map;

public class java_38074_SessionManager_A08 {
    // A map to hold sessions, using session IDs as keys
    private Map<String, Session> sessions;

    // Initialize sessions as empty maps
    public java_38074_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with ID " + sessionId + " already exists");
        }
        Session session = new Session();
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session by its ID
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }
        return session;
    }

    // Remove a session by its ID
    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("No session with ID " + sessionId + " exists");
        }
        sessions.remove(sessionId);
    }
}