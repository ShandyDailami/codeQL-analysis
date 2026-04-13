import java.util.HashMap;
import java.util.Map;

public class java_11876_SessionManager_A08 {
    // Data structure to hold user sessions
    private Map<String, String> sessionMap;

    // Initialize session map
    public java_11876_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUserId) {
        // Check if session exists
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }

        // Check if the session is valid for the expected user
        String actualUserId = sessionMap.get(sessionId);
        if (!actualUserId.equals(expectedUserId)) {
            throw new SecurityException("User ID mismatch: " + sessionId);
        }

        // If everything is correct, return true
        return true;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}