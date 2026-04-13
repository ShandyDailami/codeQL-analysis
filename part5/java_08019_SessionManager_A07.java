import java.util.HashMap;
import java.util.Map;

public class java_08019_SessionManager_A07 {
    // A HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_08019_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Generate a unique session ID
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }

    // Method to get the user ID from a session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}