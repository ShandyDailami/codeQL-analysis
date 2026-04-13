import java.util.HashMap;

public class java_11100_SessionManager_A07 {
    // Use a HashMap to store sessions
    private HashMap<String, String> sessions;

    // Initialise the sessions map
    public java_11100_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session key
        String sessionKey = userId + System.currentTimeMillis();
        sessions.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to validate a session
    public boolean validateSession(String sessionKey) {
        // If the session key is in the map, return true
        // Otherwise, return false
        return sessions.containsKey(sessionKey);
    }

    // Method to get the userId associated with a session
    public String getUserId(String sessionKey) {
        // If the session key is in the map, return the userId
        // Otherwise, return null
        return sessions.getOrDefault(sessionKey, null);
    }
}