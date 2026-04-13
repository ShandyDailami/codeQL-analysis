import java.util.HashMap;
import java.util.Map;

public class java_20991_SessionManager_A07 {
    // Using a HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_20991_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session key (UUID is used here as example)
        String sessionKey = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Check if the sessionKey is in the map
        if(sessionMap.containsKey(sessionKey)) {
            // Return the userId from the map
            return sessionMap.get(sessionKey);
        } else {
            // If the sessionKey is not in the map, return null
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the sessionKey from the map
        sessionMap.remove(sessionKey);
    }
}