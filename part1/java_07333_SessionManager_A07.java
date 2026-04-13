import java.util.HashMap;
import java.util.Map;

public class java_07333_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07333_SessionManager_A07() {
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
        // This is a simple session ID generation. In a real-world application, you would likely want to use a secure random ID.
        return String.valueOf(System.currentTimeMillis());
    }
}