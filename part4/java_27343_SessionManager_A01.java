import java.util.HashMap;
import java.util.Map;

public class java_27343_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    public java_27343_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1); // Generate a session ID
        sessionMap.put(sessionId, userId); // Store the session ID and user ID in the map
        return sessionId;
    }

    // Method to get the user ID for a given session ID
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId); // Remove the session ID from the map
    }
}