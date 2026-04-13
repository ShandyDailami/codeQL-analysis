import java.util.HashMap;
import java.util.Map;

public class java_36212_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36212_SessionManager_A03() {
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
}