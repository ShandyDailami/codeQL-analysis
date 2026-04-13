import java.util.HashMap;
import java.util.Map;

public class java_38343_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_38343_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
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

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidSession(String sessionId, String expectedUserId) {
        if (hasSession(sessionId)) {
            return getUserIdBySessionId(sessionId).equals(expectedUserId);
        }
        return false;
    }

    public void updateSession(String sessionId, String newUserId) {
        if (hasSession(sessionId)) {
            deleteSession(sessionId);
            createSession(sessionId, newUserId);
        }
    }
}