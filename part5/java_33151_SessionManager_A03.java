import java.util.HashMap;
import java.util.Map;

public class java_33151_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33151_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // Generate session id
        String sessionId = "session" + userId;
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Retrieve user id from session id
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        // Invalidate session by removing user id from session map
        sessionMap.remove(sessionId);
    }
}