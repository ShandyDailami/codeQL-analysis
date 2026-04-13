import java.util.HashMap;
import java.util.Map;

public class java_36382_SessionManager_A01 {
    // Define a HashMap to store sessions.
    private Map<String, String> sessions;

    // Constructor
    public java_36382_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a random session key
        String sessionKey = String.valueOf(System.currentTimeMillis());

        // Add the session to the map
        sessions.put(sessionKey, userId);

        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Get the user ID from the session key
        String userId = sessions.get(sessionKey);

        return userId;
    }

    // Method to destroy a session
    public void destroySession(String sessionKey) {
        // Remove the session from the map
        sessions.remove(sessionKey);
    }
}