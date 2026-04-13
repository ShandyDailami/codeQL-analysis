import java.util.HashMap;
import java.util.Map;

public class java_10458_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private Map<String, Boolean> activeSessionMap;

    public java_10458_SessionManager_A07() {
        sessionMap = new HashMap<>();
        activeSessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        activeSessionMap.put(sessionId, true);
        return sessionId;
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId) && activeSessionMap.get(sessionId)) {
            activeSessionMap.put(sessionId, false);
            sessionMap.remove(sessionId);
        }
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy session ID generation. You should replace it with your own logic.
        return String.valueOf(System.currentTimeMillis());
    }
}