import java.util.HashMap;
import java.util.Map;

public class java_12630_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12630_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
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
        // This is a dummy method. Replace it with a secure method.
        // For instance, we can use UUIDs or a secure random number generator.
        return String.valueOf(System.currentTimeMillis());
    }
}