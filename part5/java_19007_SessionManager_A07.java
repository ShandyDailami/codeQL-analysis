import java.util.HashMap;
import java.util.Map;

public class java_19007_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19007_SessionManager_A07() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy session id generation for simplicity, in real-world applications,
        // the session id should be generated server-side.
        return "sessionId" + System.currentTimeMillis();
    }
}