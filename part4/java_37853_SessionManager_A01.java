import java.util.HashMap;
import java.util.Map;

public class java_37853_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_37853_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a random session ID
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}