import java.util.HashMap;
import java.util.Map;

public class java_10320_SessionManager_A01 {
    // Create a HashMap to store sessions
    private Map<String, Session> sessions;

    // Initialize the sessions map
    public java_10320_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Error: Session already exists!";
        }
        sessions.put(sessionId, new Session(sessionId));
        return "Success: Session created!";
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class to hold session data
    class Session {
        private String sessionId;

        public java_10320_SessionManager_A01(String sessionId) {
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