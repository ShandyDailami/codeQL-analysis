import java.util.HashMap;
import java.util.Map;

public class java_02954_SessionManager_A07 {
    // private HashMap to store users sessions
    private Map<String, String> sessionMap;

    // constructor
    public java_02954_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session for a user
    public String createSession(String userId) {
        // Generate a unique sessionId for the user
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate the session
    public String validateSession(String sessionId) {
        // Check if the sessionId exists in sessionMap
        if (sessionMap.containsKey(sessionId)) {
            // If session exists, return the userId of the session
            return sessionMap.get(sessionId);
        } else {
            // If session does not exist, return null
            return null;
        }
    }

    // Method to remove the session
    public void removeSession(String sessionId) {
        // Remove the session from the sessionMap
        sessionMap.remove(sessionId);
    }
}