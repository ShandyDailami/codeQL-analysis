import java.util.HashMap;
import java.util.Map;

public class java_27102_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_27102_SessionManager_A03() {
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
        // This is a simple method to generate session id
        // In a real-world application, you should use a UUID or a secure random method
        return String.valueOf(System.currentTimeMillis());
    }
}