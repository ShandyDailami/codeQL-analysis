import java.util.HashMap;

public class java_15602_SessionManager_A03 {
    // Data structure for session storage
    private HashMap<String, Session> sessionMap;

    // Constructor
    public java_15602_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Session creation method
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists!";
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return "Session created successfully!";
        }
    }

    // Session retrieval method
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session deletion method
    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully!";
        } else {
            return "Error: Session does not exist!";
        }
    }

    // Session class
    private class Session {
        private String sessionId;

        public java_15602_SessionManager_A03(String sessionId) {
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