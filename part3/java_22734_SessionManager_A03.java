import java.util.HashMap;
import java.util.Map;

public class java_22734_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_22734_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists!");
        }
        sessionMap.put(sessionId, "Session Data");
    }

    public String getSessionData(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        sessionMap.remove(sessionId);
    }
}