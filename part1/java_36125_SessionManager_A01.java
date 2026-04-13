import java.util.HashMap;
import java.util.Map;

public class java_36125_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_36125_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserId);
        }
    }
}