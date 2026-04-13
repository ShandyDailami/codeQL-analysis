import java.util.HashMap;
import java.util.Map;

public class java_03704_SessionManager_A01 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_03704_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Create a unique session key
        String sessionKey = "SESSION_" + username;
        
        // Store the session key and username in the map
        sessionMap.put(sessionKey, username);
        
        // Return the session key
        return sessionKey;
    }

    // Method to check if a session is valid
    public String checkSession(String sessionKey) {
        // Check if the session key is in the map
        if (sessionMap.containsKey(sessionKey)) {
            // Return the username associated with the session key
            return sessionMap.get(sessionKey);
        } else {
            // Return null if the session key is not valid
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionKey) {
        // Remove the session key from the map
        sessionMap.remove(sessionKey);
    }
}