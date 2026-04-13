import java.util.HashMap;
import java.util.Map;

public class java_34722_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34722_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            return false;
        }
        return userId.equals(expectedUserId);
    }
}