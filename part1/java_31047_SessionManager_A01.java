import java.util.HashMap;
import java.util.Map;

public class java_31047_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31047_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "active");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String isSessionActive(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Inactive";
        }
    }
}