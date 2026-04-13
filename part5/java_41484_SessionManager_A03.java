import java.util.HashMap;
import java.util.Map;

public class java_41484_SessionManager_A03 {
    // Create a map to store session data
    private Map<String, Session> sessionMap;

    public java_41484_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to get session information
    public String getSessionInfo(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            return session.getInfo();
        } else {
            return "Session not found!";
        }
    }

    // Session class
    class Session {
        private String sessionId;

        public java_41484_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        // Method to get session information
        public String getInfo() {
            // Here you can add real-world logic of security sensitive operations.
            // For example, this method may use sessionId to get sensitive data from a database.
            return "Session info: " + sessionId;
        }
    }
}