import java.util.HashMap;
import java.util.Map;

public class java_25843_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25843_SessionManager_A08() {
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

    // For simplicity, we assume that the session is valid if its user ID is in our list of allowed users
    public boolean isSessionValid(String sessionId, String allowedUserId) {
        String userId = sessionMap.get(sessionId);
        return userId != null && userId.equals(allowedUserId);
    }
}