import java.util.HashMap;
import java.util.Map;

public class java_14616_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14616_SessionManager_A07() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // for generating session ID
    private String generateSessionId() {
        // This is a simple example, in real application, the session ID should be generated
        // by some random string and a timestamp, not just a simple counter
        return String.valueOf(sessionMap.size());
    }
}