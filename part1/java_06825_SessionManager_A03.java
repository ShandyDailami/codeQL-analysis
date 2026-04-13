import java.util.HashMap;
import java.util.Map;

public class java_06825_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_06825_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Insert code here to validate and initialize session
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // Insert code here to validate and return userId
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Insert code here to end session and remove session from sessionMap
        sessionMap.remove(sessionId);
    }
}