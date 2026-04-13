import java.util.HashMap;
import java.util.Map;

public class java_06657_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06657_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}