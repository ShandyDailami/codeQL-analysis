import java.util.HashMap;
import java.util.Map;

public class java_23539_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_23539_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}