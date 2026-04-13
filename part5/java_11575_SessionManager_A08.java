import java.util.HashMap;
import java.util.Map;

public class java_11575_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11575_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Invalid session ID");
        }
    }
}