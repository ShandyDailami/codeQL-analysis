import java.util.HashMap;
import java.util.Map;

public class java_32789_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_32789_SessionManager_A07() {
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

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // generate a random session id for security reasons
        return "SESSION_" + System.currentTimeMillis();
    }
}