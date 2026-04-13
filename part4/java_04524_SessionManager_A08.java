import java.util.HashMap;
import java.util.Map;

public class java_04524_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04524_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        sessionMap.put(sessionId, "Inactive");
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.get(sessionId);
    }
}