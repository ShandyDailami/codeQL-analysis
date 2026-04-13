import java.util.HashMap;
import java.util.Map;

public class java_30012_SessionManager_A08 {
    // Step 1: Declare a HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_30012_SessionManager_A08() {
        // Step 2: Initialize the HashMap
        sessionMap = new HashMap<>();
    }

    // Step 3: Method to create a new session
    public String createSession(String userId) {
        // Step 4: Generate a unique session ID and store it in the HashMap
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Step 5: Method to get the user ID from a session
    public String getUserId(String sessionId) {
        // Step 6: Check if the session ID is valid and in the HashMap
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Step 7: Handle the case where the session ID is invalid
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Step 8: Method to destroy a session
    public void destroySession(String sessionId) {
        // Step 9: Remove the session ID from the HashMap
        sessionMap.remove(sessionId);
    }
}