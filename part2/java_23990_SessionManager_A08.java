import java.util.HashMap;
import java.util.Map;

public class java_23990_SessionManager_A08 {

    // Using a HashMap to store session IDs and their corresponding values
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserIdFromSession(String sessionId) {
        // Check if the session exists in the map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}