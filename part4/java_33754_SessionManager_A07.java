import java.util.HashMap;
import java.util.Map;

public class java_33754_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33754_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}