import java.util.HashMap;
import java.util.Map;

public class java_14069_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_14069_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void changeSessionUser(String sessionId, String newUserId) {
        String oldUserId = sessionMap.get(sessionId);
        if (oldUserId != null) {
            sessionMap.put(sessionId, newUserId);
        }
    }
}