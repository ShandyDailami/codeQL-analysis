import java.util.HashMap;
import java.util.Map;

public class java_35070_SessionManager_A08 {
    private Map<String, String> sessionMap;

    // Constructor
    public java_35070_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        // Check for integrity (null or empty userId)
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        // Generate a session id
        String sessionId = generateSessionId();

        // Store the session id and user id in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Check for integrity (null or empty sessionId)
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid session ID");
        }

        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }

    // Method to get the user id from a session
    public String getUserId(String sessionId) {
        // Check for integrity (null or empty sessionId)
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid session ID");
        }

        // Retrieve the user id from the session map
        return sessionMap.get(sessionId);
    }

    // Helper method to generate a session id
    private String generateSessionId() {
        // This is a simple example and does not provide a secure, unique id
        // In a real application, you would need to use a more complex mechanism
        // to generate a unique id securely
        return "sessionId";
    }
}