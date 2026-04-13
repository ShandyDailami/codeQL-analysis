import java.util.HashMap;
import java.util.Map;

public class java_01603_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01603_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}