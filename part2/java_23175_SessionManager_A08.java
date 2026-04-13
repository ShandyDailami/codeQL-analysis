import java.util.HashMap;
import java.util.Map;

public class java_23175_SessionManager_A08 {

    // Private field to hold the session data
    private Map<String, String> sessionData;

    // Constructor
    public java_23175_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Generate a session ID
        String sessionId = generateSessionId(userId);

        // Store the session ID and user ID in the session data
        sessionData.put(sessionId, userId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Remove the session ID and user ID from the session data
        sessionData.remove(sessionId);
    }

    // Method to get the user ID for a session
    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Get the user ID from the session data
        return sessionData.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Validate the session by checking if it exists in the session data
        return sessionData.containsKey(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId(String userId) {
        // This method should generate a unique session ID for each user
        // For simplicity, we just return the user ID
        return userId;
    }
}