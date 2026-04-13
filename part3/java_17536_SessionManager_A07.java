import java.util.HashMap;
import java.util.Map;

// SessionManager Class
public class java_17536_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17536_SessionManager_A07() {
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
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session ID
    private String generateSessionId() {
        // In a real application, this method should generate a unique session ID
        // using a UUID or similar
        return String.valueOf(System.currentTimeMillis());
    }
}