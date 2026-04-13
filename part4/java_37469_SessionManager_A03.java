import java.util.HashMap;

public class java_37469_SessionManager_A03 {
    // Create a HashMap to store user sessions
    private HashMap<String, String> sessionMap;

    // Initialize the session map
    public java_37469_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a session id
        String sessionId = userId + System.currentTimeMillis();

        // Store the session id and user id in the session map
        sessionMap.put(sessionId, userId);

        // Return the session id
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user id associated with the session id
            return sessionMap.get(sessionId);
        } else {
            // Return null if the session id is not in the session map
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }
}