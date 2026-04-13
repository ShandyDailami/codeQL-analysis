import java.util.HashMap;
import java.util.Map;

public class java_04820_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04820_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionId(String userId) {
        return sessionMap.get(userId);
    }

    public boolean isValidSession(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }
}