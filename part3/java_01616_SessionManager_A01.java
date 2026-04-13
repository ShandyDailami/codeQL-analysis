import java.util.HashMap;
import java.util.Map;

public class java_01616_SessionManager_A01 {
    // Define a HashMap to hold session ids and sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_01616_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a random session id
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        if(validateSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // This session is either not valid or expired, handle accordingly
            return null;
        }
    }
}