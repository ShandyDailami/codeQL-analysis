import java.util.HashMap;
import java.util.Map;

public class java_27816_SessionManager_A07 {
    // Map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_27816_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session ID
        String sessionId = userId + System.currentTimeMillis();

        // Store session ID in map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if session ID exists in map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user ID of the session
            return sessionMap.get(sessionId);
        } else {
            // Session ID is invalid
            throw new SecurityFailureException("Invalid Session");
        }
    }
}