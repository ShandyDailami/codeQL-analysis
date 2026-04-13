import java.util.HashMap;
import java.util.Map;

public class java_17759_SessionManager_A07 {
    // Use a HashMap as a session store
    private Map<String, String> sessionMap;

    // Constructor
    public java_17759_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a session key
        String sessionKey = String.valueOf(System.currentTimeMillis());

        // Store the username and session key in the session map
        sessionMap.put(sessionKey, username);

        // Return the session key
        return sessionKey;
    }

    // Method to get the username from a session
    public String getUsername(String sessionKey) {
        // Check if the session map contains the session key
        if (sessionMap.containsKey(sessionKey)) {
            // Return the username
            return sessionMap.get(sessionKey);
        } else {
            // Return null if the session key is not found
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionKey) {
        // Remove the session from the session map
        sessionMap.remove(sessionKey);
    }
}