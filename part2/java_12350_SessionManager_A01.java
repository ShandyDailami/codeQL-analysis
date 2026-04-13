import java.util.HashMap;
import java.util.Map;

public class java_12350_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12350_SessionManager_A01() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis(), Character.MAX_RADIX);
    }
}