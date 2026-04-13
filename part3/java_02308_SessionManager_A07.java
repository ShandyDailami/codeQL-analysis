import java.util.HashMap;
import java.util.Map;

public class java_02308_SessionManager_A07 {
    // Store session data in a Map
    private Map<String, String> sessionMap;

    public java_02308_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId associated with a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}