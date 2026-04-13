import java.util.HashMap;
import java.util.Map;

public class java_14196_SessionManager_A07 {
    // Use a HashMap to store session data
    private Map<String, Object> sessionData;

    // Constructor
    public java_14196_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        // Generate a session ID
        String sessionId = userId + System.currentTimeMillis();

        // Store the user ID in the session data
        sessionData.put(sessionId, userId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the user ID from the session data
        sessionData.remove(sessionId);
    }

    // Method to get the user ID for a session
    public String getUserId(String sessionId) {
        // Return the user ID from the session data
        return (String) sessionData.get(sessionId);
    }

    // Method to check if a session is active
    public boolean isActiveSession(String sessionId) {
        // Return true if the session data contains the user ID
        return sessionData.containsKey(sessionId);
    }
}