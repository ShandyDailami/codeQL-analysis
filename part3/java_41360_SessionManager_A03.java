import java.util.HashMap;
import java.util.Map;

public class java_41360_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_41360_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method should generate a unique session ID
        // For simplicity, we'll use the user ID
        return "session_" + System.currentTimeMillis();
    }
}