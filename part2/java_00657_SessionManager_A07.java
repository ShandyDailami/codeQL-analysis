import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_00657_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00657_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}