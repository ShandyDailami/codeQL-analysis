import java.util.HashMap;
import java.util.Map;

public class java_20838_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20838_SessionManager_A07() {
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

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operation: A07_AuthFailure
    public void authFailure(String sessionId) {
        String userId = sessionMap.get(sessionId);
        // Authentication failure code here
        //...
    }
}