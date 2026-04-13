import java.util.Map;
import java.util.HashMap;

public class java_17572_SessionManager_A03 {
    private static SessionManager instance = null;
    private Map<String, Session> sessions;

    // Private constructor to prevent instantiation from outside
    private java_17572_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Singleton pattern
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Public method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    // Public method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    class Session {
        private String sessionId;

        public java_17572_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}