import java.util.HashMap;
import java.util.Map;

public class java_16960_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16960_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserIdBySessionId(String sessionId, String newUserId) {
        sessionMap.replace(sessionId, newUserId);
    }
}