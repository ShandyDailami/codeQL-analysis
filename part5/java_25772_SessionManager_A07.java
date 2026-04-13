import java.util.HashMap;

public class java_25772_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_25772_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a unique session ID
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user ID from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}