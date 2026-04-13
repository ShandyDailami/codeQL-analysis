import java.util.HashMap;
import java.util.Map;

public class java_04031_SessionManager_A07 {
    // A map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_04031_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = String.valueOf(userId.hashCode());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user id associated with the session id
            return sessionMap.get(sessionId);
        } else {
            // Return null if the session id is not valid
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session id from the map
        sessionMap.remove(sessionId);
    }
}