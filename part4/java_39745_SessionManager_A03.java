import java.util.HashMap;

public class java_39745_SessionManager_A03 {
    // SessionManager is a singleton so there's only one instance of this class
    private static SessionManager instance;

    // A map to hold sessions. Key is session ID, value is session object.
    private HashMap<String, Session> sessions;

    // Private constructor to prevent external instantiation
    private java_39745_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Static method to get the instance of SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session by ID
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }
        return session;
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_39745_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public void destroySession() {
            sessions.remove(sessionId);
        }
    }
}