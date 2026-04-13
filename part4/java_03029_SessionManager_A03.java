import java.util.HashMap;
import java.util.Map;

public class java_03029_SessionManager_A03 {
    // In-memory storage for user sessions
    private Map<String, String> sessionMap;

    public java_03029_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Generate a random session ID
        String sessionId = generateRandomSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if session ID exists in the map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user ID associated with the session ID
            return sessionMap.get(sessionId);
        } else {
            // Session ID does not exist in the map
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }

    // Method to generate a random session ID
    private String generateRandomSessionId() {
        // This is a placeholder. In a real-world application, you should use a secure method for generating session IDs.
        return "A03_Injection";
    }
}