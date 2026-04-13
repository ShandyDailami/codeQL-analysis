import java.util.HashMap;
import java.util.Map;

public class java_25957_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25957_SessionManager_A08() {
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

    private String generateSessionId() {
        // This is a simple implementation of a session id generator. In a real application,
        // this method would likely use a cryptographic hash or similar to ensure uniqueness.
        return String.valueOf(System.currentTimeMillis());
    }
}