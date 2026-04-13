import java.util.HashMap;
import java.util.Map;

public class java_06561_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06561_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (isValidSession(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}