import java.util.Map;
import java.util.HashMap;

public class java_04944_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_04944_SessionManager_A01() {
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

    // Add more methods for other operations if needed
}