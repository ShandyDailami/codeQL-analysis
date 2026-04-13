import java.util.HashMap;
import java.util.Map;

public class java_23697_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_23697_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}