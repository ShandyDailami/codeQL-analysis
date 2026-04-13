import java.util.HashMap;
import java.util.Map;

public class java_27082_SessionManager_A03 {

    // Create a map to hold the sessions.
    private Map<String, Session> sessionMap;

    // Default constructor.
    public java_27082_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to retrieve a session.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session class.
    public class Session {
        private String sessionId;

        // Session constructor.
        public java_27082_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        // Method to retrieve the session ID.
        public String getSessionId() {
            return sessionId;
        }

        // Method to set the session ID.
        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}