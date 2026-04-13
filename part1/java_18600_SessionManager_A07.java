import java.util.HashMap;

public class java_18600_SessionManager_A07 {
    // Define a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Initialize the session map
    public java_18600_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Generate a session key
        String sessionKey = Integer.toString(userId.hashCode());

        // Store the session key and user id in the session map
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to get the user id from a session
    public String getUserId(String sessionKey) {
        // Check if the session key exists in the session map
        if (sessionMap.containsKey(sessionKey)) {
            // Return the user id from the session map
            return sessionMap.get(sessionKey);
        }

        // Return null if the session key does not exist in the session map
        return null;
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }
}