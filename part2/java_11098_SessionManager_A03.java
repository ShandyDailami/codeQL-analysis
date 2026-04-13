import java.util.HashMap;
import java.util.Map;

public class java_11098_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11098_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}