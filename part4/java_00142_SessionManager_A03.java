import java.util.HashMap;
import java.util.Map;

public class java_00142_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00142_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Generate a random session ID for security-sensitive operations
        // This is a simplistic example, in a real application you would likely use a UUID or some other unique identifier
        return String.valueOf(System.currentTimeMillis());
    }
}