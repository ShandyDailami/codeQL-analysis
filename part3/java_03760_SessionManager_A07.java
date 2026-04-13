import java.util.HashMap;
import java.util.Map;

public class java_03760_SessionManager_A07 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String userId) {
        // Create a unique session ID
        String sessionId = UUID.randomUUID().toString();

        // Store the user ID and session ID in the session map
        sessionMap.put(sessionId, userId);

        // Return the session ID
        return sessionId;
    }

    // Method to get the user ID from a session ID
    public String getUserIdFromSession(String sessionId) {
        // Return the user ID from the session map
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Return true if the session is valid, false otherwise
        return sessionMap.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}