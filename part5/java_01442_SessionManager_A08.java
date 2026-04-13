import java.util.HashMap;
import java.util.Map;

public class java_01442_SessionManager_A08 {

    // Using a HashMap to store session information
    private Map<String, Session> sessions;

    public java_01442_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return "Session created";
        }
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            return session.getSessionId();
        } else {
            return "Session does not exist";
        }
    }

    // Session class
    private class Session {
        private String sessionId;

        public java_01442_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}