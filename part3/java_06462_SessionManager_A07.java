import java.util.HashMap;
import java.util.Map;

public class java_06462_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06462_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // User not found
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }
}