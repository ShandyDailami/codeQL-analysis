import java.util.HashMap;
import java.util.Map;

public class java_12178_SessionManager_A03 {
    // Create a HashMap to hold user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_12178_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from the session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate if the session is valid
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}