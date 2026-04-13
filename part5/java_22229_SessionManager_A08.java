import java.util.HashMap;

public class java_22229_SessionManager_A08 {
    // A map for storing sessions
    private HashMap<String, String> sessionMap;

    public java_22229_SessionManager_A08() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String userId) {
        // Generate a session id
        String sessionId = String.valueOf(userId.hashCode());

        // Store the session id and user id in the map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method for validating a session
    public boolean validateSession(String sessionId, String expectedUserId) {
        // Retrieve the user id from the map
        String userId = sessionMap.get(sessionId);

        // Compare the retrieved user id with the expected user id
        // If they match, return true, otherwise false
        return userId != null && userId.equals(expectedUserId);
    }

    // Method for ending a session
    public void endSession(String sessionId) {
        // Remove the session id from the map
        sessionMap.remove(sessionId);
    }
}