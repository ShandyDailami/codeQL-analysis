import java.util.HashMap;
import java.util.Map;

public class java_14093_SessionManager_A03 {
    // Create a map to hold sessions
    private static Map<String, Session> sessions = new HashMap<>();

    // Private constructor to prevent creation of new instances
    private java_14093_SessionManager_A03() {
    }

    // Static method to get the SessionManager instance
    public static SessionManager getInstance() {
        return Holder.instance;
    }

    // Private static class to hold the SessionManager instance
    private static class Holder {
        private static final SessionManager instance = new SessionManager();
    }

    // Create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Destroy a session
    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Retrieve a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_14093_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public String toString() {
            return "Session [sessionId=" + sessionId + "]";
        }
    }
}