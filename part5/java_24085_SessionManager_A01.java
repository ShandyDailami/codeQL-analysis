import java.util.HashMap;
import java.util.Map;

public class java_24085_SessionManager_A01 {

    // Create a Map to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_24085_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = generateSessionId();
        // Store the session id and user id in the session map
        sessionMap.put(sessionId, userId);
        // Return the session id
        return sessionId;
    }

    // Method to get the user id from a session
    public String getUserId(String sessionId) {
        // Check if the session id is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user id
            return sessionMap.get(sessionId);
        } else {
            // If the session id is not in the session map, return null
            return null;
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a unique session id
    private String generateSessionId() {
        // This is a very simple method, in a real-world scenario, you would need a more complex method to generate a unique id
        // Here, we just generate a random string
        return String.valueOf(System.currentTimeMillis());
    }
}