import java.util.HashMap;
import java.util.Map;

public class java_18109_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18109_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void clearSessions() {
        sessionMap.clear();
    }
}