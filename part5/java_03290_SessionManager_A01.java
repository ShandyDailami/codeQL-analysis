import java.util.HashMap;
import java.util.Map;

public class java_03290_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03290_SessionManager_A01() {
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

    public boolean isSessionActive(String userId) {
        return sessionMap.containsKey(userId);
    }
}