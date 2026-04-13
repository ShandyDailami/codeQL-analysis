import java.util.HashMap;
import java.util.Map;

public class java_41580_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41580_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = "SESSION_" + userId;
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}