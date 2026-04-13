import java.util.HashMap;
import java.util.Map;

public class java_12803_SessionManager_A08 {

    // Create a private Map to hold sessions
    private Map<String, Session> sessionMap;

    // Constructor
    public java_12803_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists for the given id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session found for the given id: " + sessionId);
        }
        return session;
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_12803_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Add other methods as per requirement
    }
}