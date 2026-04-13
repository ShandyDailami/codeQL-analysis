import java.util.HashMap;

public class java_28178_SessionManager_A03 {
    // A HashMap to store session objects
    private HashMap<String, Session> sessions;

    // Default constructor
    public java_28178_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists!");
            return null;
        }

        // If not in use, create a new session
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if sessionId is valid
        if (!sessions.containsKey(sessionId)) {
            System.out.println("No session with id " + sessionId + " found!");
            return null;
        }

        // If sessionId is valid, return the session
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        // Session constructor
        public java_28178_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        // Session getter
        public String getSessionId() {
            return sessionId;
        }

        // Session setter
        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}