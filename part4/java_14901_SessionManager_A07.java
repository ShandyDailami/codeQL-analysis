import java.util.HashMap;
import java.util.Map;

public class java_14901_SessionManager_A07 {
    // Using HashMap as a simple backing store
    private Map<String, String> sessionMap;

    public java_14901_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            // Session already exists
            return null;
        } else {
            sessionMap.put(sessionId, userId);
            return sessionId;
        }
    }

    // Method to get the userId for a given session
    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Session does not exist
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}