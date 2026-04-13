import java.util.HashMap;
import java.util.Map;

public class java_07103_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_07103_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
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
        return java.util.UUID.randomUUID().toString();
    }
}