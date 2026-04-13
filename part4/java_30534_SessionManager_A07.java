import java.util.HashMap;
import java.util.Map;

public class java_30534_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_30534_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(userId, sessionId);
            return sessionId;
        }
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}