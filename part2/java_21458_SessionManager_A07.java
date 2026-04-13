import java.util.HashMap;

public class java_21458_SessionManager_A07 {
    // Create a private HashMap to store sessions
    private HashMap<String, Session> sessions;

    public java_21458_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    // Validate session
    public boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessions.containsKey(sessionId);
    }

    // Get session data
    public Session getSession(String sessionId) {
        if (!validateSession(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }
        return sessions.get(sessionId);
    }

    // Clear session
    public void clearSession(String sessionId) {
        if (!validateSession(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }
        sessions.remove(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_21458_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}