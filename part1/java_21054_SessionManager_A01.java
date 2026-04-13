import java.util.HashMap;
import java.util.Map;

public class java_21054_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_21054_SessionManager_A01() {
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
        // This is a simple example, in a real-world application you would want to use a UUID or a similar method to generate a unique session id
        return String.valueOf(System.currentTimeMillis());
    }
}