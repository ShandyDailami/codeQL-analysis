import java.util.HashMap;
import java.util.Map;

public class java_20859_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20859_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get user from session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}