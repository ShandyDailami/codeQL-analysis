import java.util.HashMap;
import java.util.Map;

public class java_19687_SessionManager_A07 {

    // Store sessions in a HashMap
    private Map<String, String> sessionMap;

    public java_19687_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session ID
        String sessionId = "SESSION_" + userId;

        // Store the session ID in the map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID exists in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user ID from a session
    public String getUserIdFromSession(String sessionId) {
        // If the session ID exists in the map, return the corresponding user ID
        if (validateSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session ID does not exist, return null
            return null;
        }
    }
}