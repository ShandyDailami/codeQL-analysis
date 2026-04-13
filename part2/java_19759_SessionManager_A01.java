import java.util.HashMap;
import java.util.Map;

public class java_19759_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19759_SessionManager_A01() {
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

    // Assuming a session is only valid for a certain duration (e.g., 1 hour)
    public void validateSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            throw new IllegalStateException("Invalid session");
        }
    }
}