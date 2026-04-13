import java.util.HashMap;
import java.util.Map;

public class java_01070_SessionManager_A08 {
    // Create a map to store sessions
    private Map<String, Session> sessionMap;

    public java_01070_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("SessionId must not be null or empty");
        }
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with the id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("SessionId must not be null or empty");
        }
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists with the id: " + sessionId);
        }
        return session;
    }

    // Remove a session
    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("SessionId must not be null or empty");
        }
        Session session = sessionMap.remove(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists with the id: " + sessionId);
        }
    }

    // Session class
    public static class Session {
        private String id;

        public java_01070_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}