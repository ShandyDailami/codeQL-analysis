import java.util.HashMap;
import java.util.Map;

public class java_12374_SessionManager_A01 {
    // A map to store session data
    private Map<String, String> sessionMap;

    public java_12374_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        // Generate a session id
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the session id and username in the map
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id is in the map
        if (sessionMap.containsKey(sessionId)) {
            // If it is, return the corresponding username
            return sessionMap.get(sessionId);
        } else {
            // If it's not, return null to indicate the session is invalid
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session id and username from the map
        sessionMap.remove(sessionId);
    }
}