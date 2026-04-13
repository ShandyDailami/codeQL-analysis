import java.util.HashMap;
import java.util.Map;

public class java_12830_SessionManager_A03 {
    // Using HashMap as a session storage
    private Map<String, String> sessionMap;

    public java_12830_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session ID
    private String generateSessionId() {
        return String.valueOf(System.nanoTime()); // Fictitious method
    }
}