import java.util.HashMap;
import java.util.Map;

public class java_03786_SessionManager_A07 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    public java_03786_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a unique session key
        String sessionKey = userId + System.currentTimeMillis();
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Validate the session
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // End the session
        sessionMap.remove(sessionKey);
    }
}