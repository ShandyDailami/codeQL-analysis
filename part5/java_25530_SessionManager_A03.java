import java.util.HashMap;
import java.util.Map;

public class java_25530_SessionManager_A03 {
    // Map to store session data
    private Map<String, String> sessionMap;

    public java_25530_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session id
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user id from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}