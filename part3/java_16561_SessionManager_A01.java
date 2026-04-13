import java.util.HashMap;
import java.util.UUID;

public class java_16561_SessionManager_A01 {
    // A HashMap to store session data
    private HashMap<String, Session> sessionMap;

    // Constructor
    public java_16561_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, username);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to validate a session
    public Session validateSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            System.out.println("Invalid session ID");
            return null;
        }
        return session;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;
        private String username;

        public java_16561_SessionManager_A01(String sessionId, String username) {
            this.sessionId = sessionId;
            this.username = username;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUsername() {
            return username;
        }
    }
}