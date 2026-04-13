import java.util.HashMap;
import java.util.Map;

public class java_18953_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_18953_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void closeAllSessions() {
        sessions.clear();
    }

    public class Session {
        private String sessionId;

        public java_18953_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setAttribute(String name, Object value) {
            // Session-specific operation: set attribute
            System.out.println("Setting attribute " + name + " on session " + sessionId);
        }

        public Object getAttribute(String name) {
            // Session-specific operation: get attribute
            System.out.println("Getting attribute " + name + " from session " + sessionId);
            return null; // or return default value
        }

        public void invalidate() {
            // Session-specific operation: invalidate session
            System.out.println("Invalidating session " + sessionId);
        }

        public boolean isActive() {
            // Session-specific operation: check if session is active
            System.out.println("Checking if session " + sessionId + " is active");
            return false; // or return true based on your implementation
        }
    }
}