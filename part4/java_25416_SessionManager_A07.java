import java.util.HashMap;
import java.util.Map;

public class java_25416_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25416_SessionManager_A07() {
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
        // Here you could implement a method to generate a unique session id
        // This could be a UUID, a timestamp, or any other method that ensures uniqueness
        return UUID.randomUUID().toString();
    }
}