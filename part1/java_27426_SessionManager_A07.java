import java.util.HashMap;
import java.util.Map;

public class java_27426_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27426_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserId(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserId);
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}