import java.util.HashMap;
import java.util.Map;

public class java_30160_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_30160_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Session data");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }
}