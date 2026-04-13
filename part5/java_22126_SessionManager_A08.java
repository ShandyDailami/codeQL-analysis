import java.util.HashMap;
import java.util.Map;

public class java_22126_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22126_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // Session not found
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}