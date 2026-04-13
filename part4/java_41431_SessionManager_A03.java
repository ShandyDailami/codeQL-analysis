// Start with a import statement for the Java Collections framework
import java.util.HashMap;
import java.util.Map;

public class java_41431_SessionManager_A03 {

    // Declare a private instance of Map to store session information
    private Map<String, String> sessionMap;

    // Default Constructor
    public java_41431_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a session key
        String sessionKey = userId + System.currentTimeMillis();
        // Store the session key in the map
        sessionMap.put(sessionKey, userId);
        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Check if the session key is in the map
        if (sessionMap.containsKey(sessionKey)) {
            // Return the user id associated with the session key
            return sessionMap.get(sessionKey);
        } else {
            // Return null if the session key is not in the map
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionKey) {
        // Remove the session key from the map
        sessionMap.remove(sessionKey);
    }
}