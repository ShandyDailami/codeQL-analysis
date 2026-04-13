import java.util.HashMap;

public class java_32010_SessionManager_A03 {

    // A simple HashMap to store sessions
    private HashMap<String, Session> sessions;

    public java_32010_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public Session createSession(String sessionId) {
        // Create a new session and add it to the map
        sessions.put(sessionId, new Session(sessionId));
        return sessions.get(sessionId);
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Return the session from the map
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_32010_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}