import java.util.HashMap;
import java.util.Map;

public class java_09539_SessionManager_A07 {
    // Secure session data store
    private Map<String, String> sessionData;

    // Default constructor
    public java_09539_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        // Generate a unique session ID
        String sessionId = userId + System.currentTimeMillis();

        // Store the session ID in the session data store
        sessionData.put(sessionId, userId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the session data store
        sessionData.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Check if the session ID exists in the session data store
        return sessionData.containsKey(sessionId);
    }

    // Method to get the user ID associated with a session
    public String getUserId(String sessionId) {
        // Check if the session ID is valid and return the user ID
        if (isValidSession(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            throw new SecurityException("Invalid session");
        }
    }
}