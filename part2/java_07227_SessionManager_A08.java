import java.util.HashMap;
import java.util.Map;

public class java_07227_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07227_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}