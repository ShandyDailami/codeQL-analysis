import java.util.HashMap;
import java.util.Map;

public class java_07520_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07520_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}