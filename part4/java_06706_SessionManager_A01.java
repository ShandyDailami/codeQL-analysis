import java.util.HashMap;
import java.util.Map;

public class java_06706_SessionManager_A01 {
    // Create a HashMap for storing session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_06706_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Create a random session id for the user
        String sessionId = userId + "-" + System.currentTimeMillis();

        // Store the session id in the session map
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

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }
}