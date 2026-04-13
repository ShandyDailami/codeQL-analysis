import java.util.HashMap;
import java.util.Map;

public class java_36014_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36014_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method should generate a secure session ID. For simplicity, we'll use a random UUID here.
        return java.util.UUID.randomUUID().toString();
    }
}