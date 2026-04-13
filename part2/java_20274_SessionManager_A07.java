import java.util.HashMap;
import java.util.Map;

public class java_20274_SessionManager_A07 {
    // The session map
    private Map<String, Session> sessionMap;

    // Constructor
    public java_20274_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Create a session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null || session.isExpired()) {
            return null;
        }
        return session;
    }

    // Delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class
    private class Session {
        private String sessionId;
        private long creationTime;
        private boolean isExpired;

        public java_20274_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
            this.creationTime = System.currentTimeMillis();
        }

        // Getters
        public String getSessionId() {
            return sessionId;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public boolean isExpired() {
            return isExpired;
        }

        // Setters
        public void setExpired(boolean expired) {
            isExpired = expired;
        }
    }
}