import java.util.HashMap;
import java.util.Map;

public class java_28980_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28980_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Simulate session id generation, not real-world secure session management
    private String generateSessionId() {
        return "SESSION_" + System.currentTimeMillis();
    }
}