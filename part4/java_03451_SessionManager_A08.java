import java.util.HashMap;
import java.util.Map;

public class java_03451_SessionManager_A08 {

    // A map to hold all active sessions
    private Map<String, Session> sessionMap;

    // Constructor
    public java_03451_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to retrieve an existing session
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        return session;
    }

    // Method to destroy an existing session
    public void destroySession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_03451_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Getter and Setter methods
        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}