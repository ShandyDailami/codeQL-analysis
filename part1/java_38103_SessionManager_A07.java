import java.util.HashMap;
import java.util.Map;

public class java_38103_SessionManager_A07 {
    // Create a map for storing sessions
    private Map<String, String> sessionMap;

    public java_38103_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUsername) {
        // Check if the session ID is in the map
        if (sessionMap.containsKey(sessionId)) {
            // Check if the username in the session matches the expected username
            if (sessionMap.get(sessionId).equals(expectedUsername)) {
                return true;
            }
        }
        return false;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}