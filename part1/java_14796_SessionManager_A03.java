import java.util.HashMap;
import java.util.Map;

public class java_14796_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_14796_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // A03_Injection point: we are using userId directly in the sessionId to avoid injection
        String sessionId = userId + "_sessionId";
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // A03_Injection point: we are using sessionId directly in the getUserId method to avoid injection
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}