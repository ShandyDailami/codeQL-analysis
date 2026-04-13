import java.util.HashMap;

public class java_20468_SessionManager_A07 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessions = new HashMap<>();

    // Method to create a session
    public String createSession(String userId) {
        // Generate a unique session key
        String sessionKey = userId + System.currentTimeMillis();

        // Store the session key and user ID in the HashMap
        sessions.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Retrieve the user ID from the HashMap
        String userId = sessions.get(sessionKey);

        // Return the user ID
        return userId;
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session key and user ID from the HashMap
        sessions.remove(sessionKey);
    }
}