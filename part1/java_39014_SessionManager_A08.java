import java.util.HashMap;
import java.util.Map;

public class java_39014_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_39014_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(username));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Helper method to generate a unique session id
    private String generateSessionId() {
        return Long.toString(System.nanoTime());
    }

    // Session class with username and last accessed time
    private class Session {
        private String username;
        private long lastAccessed;

        public java_39014_SessionManager_A08(String username) {
            this.username = username;
            this.lastAccessed = System.currentTimeMillis();
        }

        public void update() {
            lastAccessed = System.currentTimeMillis();
        }
    }
}