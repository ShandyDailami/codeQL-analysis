import java.util.HashMap;
import java.util.Map;

public class java_22840_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_22840_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(username));
        return sessionId;
    }

    public void validateSession(String sessionId) throws SecurityException {
        Session session = sessions.get(sessionId);
        if (session == null || session.isExpired()) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }

    private class Session {
        private String username;
        private long creationTime;
        private static final long EXPIRATION_TIME = 300000; // 300,000 milliseconds = 5 minutes

        private java_22840_SessionManager_A08(String username) {
            this.username = username;
            this.creationTime = System.currentTimeMillis();
        }

        private boolean isExpired() {
            long expirationTime = creationTime + EXPIRATION_TIME;
            return expirationTime < System.currentTimeMillis();
        }
    }
}