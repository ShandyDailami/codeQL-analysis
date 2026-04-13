import java.util.HashMap;
import java.util.Map;

public class java_26806_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26806_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}