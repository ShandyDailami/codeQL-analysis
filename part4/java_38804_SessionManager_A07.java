import java.util.HashMap;
import java.util.Map;

public class java_38804_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_38804_SessionManager_A07() {
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

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example of session id generation. In a real-world application, you should use a more secure method.
        return String.valueOf(System.currentTimeMillis());
    }
}