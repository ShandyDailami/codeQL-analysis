import java.util.HashMap;
import java.util.Map;

public class java_17079_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17079_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (!isSessionValid(userId, sessionId)) {
            sessionMap.put(userId, sessionId);
        }
    }

    public void endSession(String userId, String sessionId) {
        if (isSessionValid(userId, sessionId)) {
            sessionMap.remove(userId);
        }
    }

    public boolean isSessionValid(String userId, String sessionId) {
        if (sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId)) {
            return true;
        }
        return false;
    }
}