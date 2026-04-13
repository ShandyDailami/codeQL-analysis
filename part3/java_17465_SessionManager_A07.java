import java.util.HashMap;

public class java_17465_SessionManager_A07 {
    // Define a hashmap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_17465_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Create a session key by combining user id and a unique number
        String sessionKey = userId + System.currentTimeMillis();

        // Store session key in the hashmap
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Check if the session key exists in the hashmap
        if (sessionMap.containsKey(sessionKey)) {
            // Return the corresponding user id
            return sessionMap.get(sessionKey);
        } else {
            // Return null if the session key does not exist
            return null;
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionKey) {
        // Remove the session key from the hashmap
        sessionMap.remove(sessionKey);
    }
}