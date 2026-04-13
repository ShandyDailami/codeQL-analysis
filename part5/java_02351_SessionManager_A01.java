import java.util.HashMap;
import java.util.Map;

public class java_02351_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02351_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
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
        // This is a placeholder for a real-world implementation
        // It could be a random UUID, a hash, a server time, etc.
        // This is used to avoid session hijacking and is part of A01_BrokenAccessControl
        return "SESSION_ID";
    }
}