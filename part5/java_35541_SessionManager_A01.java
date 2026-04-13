import java.util.HashMap;
import java.util.Map;

public class java_35541_SessionManager_A01 {
    // In-memory map to store sessions
    private Map<String, Session> sessionMap;

    public java_35541_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public Session createSession() {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Get a session by its ID
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session by its ID
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a session ID
    private String generateSessionId() {
        // This is a simple example, in a real-world application, you would use a UUID or similar to generate a unique ID
        return "session-" + System.currentTimeMillis();
    }

    // Session class
    private class Session {
        private String id;

        public java_35541_SessionManager_A01(String id) {
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