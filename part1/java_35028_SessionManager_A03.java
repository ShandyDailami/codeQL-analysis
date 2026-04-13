import java.util.HashMap;
import java.util.Map;

public class java_35028_SessionManager_A03 {
    private Map<String, Session> sessionMap;

    // Constructor
    public java_35028_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }

        String sessionId = session.getId();
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessionMap.remove(sessionId);
    }
}