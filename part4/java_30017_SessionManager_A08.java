import java.util.HashMap;
import java.util.Map;

public class java_30017_SessionManager_A08 {
    // Create a HashMap to simulate a session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_30017_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid Session Id");
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Invalid Session Id");
        }
    }

    // Method to generate a session id
    private String generateSessionId() {
        // You can generate a unique session id using a UUID, for example
        return java.util.UUID.randomUUID().toString();
    }
}