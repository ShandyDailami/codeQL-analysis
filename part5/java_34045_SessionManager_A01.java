import java.util.HashMap;
import java.util.Map;

public class java_34045_SessionManager_A01 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    public java_34045_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a session id
    private String generateSessionId() {
        // This method could include logic to generate a unique id
        // For simplicity, we'll just use a random string
        return java.util.UUID.randomUUID().toString();
    }
}