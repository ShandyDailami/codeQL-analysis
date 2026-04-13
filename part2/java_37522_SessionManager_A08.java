import java.util.HashMap;
import java.util.Map;

public class java_37522_SessionManager_A08 {

    // Data structure to store sessions
    private Map<String, Session> sessions;

    // Default constructor
    public java_37522_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if(sessions.containsKey(sessionId)) {
            return "Error: Session ID " + sessionId + " already exists";
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return "Success: Session ID " + sessionId + " created";
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_37522_SessionManager_A08(String sessionId) {
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