import java.util.HashMap;
import java.util.Map;

public class java_30026_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_30026_SessionManager_A07() {
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

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a simple example and is not a perfect solution for authentication
    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis());
    }
}