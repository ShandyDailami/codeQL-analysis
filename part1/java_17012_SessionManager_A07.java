import java.util.HashMap;
import java.util.Map;

public class java_17012_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17012_SessionManager_A07() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simplistic example, you should not use this method in a real application
        // It's also not secure to use it for a real application
        return String.valueOf(System.currentTimeMillis());
    }
}