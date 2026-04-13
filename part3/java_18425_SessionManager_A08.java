import java.util.HashMap;
import java.util.Map;

public class java_18425_SessionManager_A08 {
    // Create a HashMap to store the sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_18425_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Generate a session ID using user ID
        String sessionId = userId + System.currentTimeMillis();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionId, userId);

        // Return the session ID
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionId);
    }

    // Method to get the user ID associated with a session
    public String getUserId(String sessionId) {
        // Return the user ID associated with the session ID
        return sessionMap.get(sessionId);
    }
}