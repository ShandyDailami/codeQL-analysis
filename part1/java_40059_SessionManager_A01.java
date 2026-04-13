import java.util.HashMap;
import java.util.Map;

public class java_40059_SessionManager_A01 {

    // Using a HashMap to store sessions
    private Map<String, Session> sessions;

    public java_40059_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Error: Session Already Exists";
        } else {
            sessions.put(sessionId, new Session(sessionId));
            return "Session Created Successfully";
        }
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to destroy a session
    public String destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session Destroyed Successfully";
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    // Session class to hold session data
    private class Session {
        private String sessionId;

        public java_40059_SessionManager_A01(String sessionId) {
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