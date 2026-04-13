import java.util.HashMap;
import java.util.Map;

public class java_04057_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04057_SessionManager_A07() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation of a session ID generator
        // It's not a secure implementation and should not be used in a production environment
        return String.valueOf(System.currentTimeMillis());
    }
}