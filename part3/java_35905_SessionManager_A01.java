import java.util.HashMap;
import java.util.Map;

public class java_35905_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_35905_SessionManager_A01() {
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
        // This is a simple implementation and not secure for real applications
        return String.valueOf(System.currentTimeMillis());
    }
}