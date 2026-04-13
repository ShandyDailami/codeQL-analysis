import java.util.HashMap;
import java.util.Map;

public class java_10414_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_10414_SessionManager_A07() {
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

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a more complex session ID generation
        return String.valueOf(System.currentTimeMillis());
    }
}