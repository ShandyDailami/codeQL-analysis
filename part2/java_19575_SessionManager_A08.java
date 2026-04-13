import java.util.HashMap;
import java.util.Map;

public class java_19575_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_19575_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add other methods as needed for session management
}