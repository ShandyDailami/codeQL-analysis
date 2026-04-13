import java.util.HashMap;
import java.util.Map;

public class java_13831_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_13831_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}