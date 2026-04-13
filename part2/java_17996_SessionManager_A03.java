import java.util.HashMap;
import java.util.Map;

public class java_17996_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_17996_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}