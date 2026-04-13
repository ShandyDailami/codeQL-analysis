import java.util.HashMap;
import java.util.Map;

public class java_39463_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39463_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session id");
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}