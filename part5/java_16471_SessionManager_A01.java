import java.util.HashMap;
import java.util.Map;

public class java_16471_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16471_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(); // This could be any operation, e.g. a random UUID
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder, you would typically use a UUID here
        // but for simplicity, we'll use a simple string
        return "sessionId";
    }
}