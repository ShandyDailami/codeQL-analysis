import java.util.HashMap;
import java.util.Map;

public class java_16030_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16030_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example, in a real system you would probably want to use a UUID or a similar unique identifier
        return String.valueOf(System.currentTimeMillis());
    }
}