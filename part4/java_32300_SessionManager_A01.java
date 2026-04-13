import java.util.HashMap;
import java.util.Map;

public class java_32300_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_32300_SessionManager_A01() {
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
        // Implement your own session id generation logic here.
        // This is a simple example and may not be suitable for security-sensitive operations.
        return "sessionId";
    }

}