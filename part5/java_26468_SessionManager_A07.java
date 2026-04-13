import java.util.HashMap;
import java.util.Map;

public class java_26468_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26468_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }
}