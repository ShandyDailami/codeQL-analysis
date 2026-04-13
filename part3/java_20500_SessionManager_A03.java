import java.util.HashMap;
import java.util.Map;

public class java_20500_SessionManager_A03 {
    // A HashMap to store user sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_20500_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the user id in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to get the user id from a session
    public String getUserId(String sessionId) {
        // Return the user id from the session map
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}