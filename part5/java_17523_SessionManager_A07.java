import java.util.HashMap;
import java.util.Map;

public class java_17523_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17523_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = "SESSION_" + userId;
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}