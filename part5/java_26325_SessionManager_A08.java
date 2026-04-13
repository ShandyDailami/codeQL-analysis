import java.util.HashMap;
import java.util.Map;

public class java_26325_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26325_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session id
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    // Add additional methods for integrity verification and other security-sensitive operations if needed
}