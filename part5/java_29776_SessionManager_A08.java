import java.util.HashMap;
import java.util.Map;

public class java_29776_SessionManager_A08 {
    // private Map to store sessionId and session object
    private Map<String, Session> sessionMap;

    // SessionManager constructor
    public java_29776_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession() {
        Session session = new Session();
        String sessionId = session.generateSessionId();
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session by sessionId
    public Session getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid sessionId");
        }
    }

    // Method to close a session by sessionId
    public void closeSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Invalid sessionId");
        }
    }

    // Session class
    public class Session {
        // Method to generate a sessionId
        public String generateSessionId() {
            // TODO: Implement the logic to generate a sessionId.
            // You can use a library or your own logic to generate a unique id.
            // For now, we'll just generate a random string.
            return java.util.UUID.randomUUID().toString();
        }
    }
}