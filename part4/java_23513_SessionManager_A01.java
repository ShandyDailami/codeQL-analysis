import java.util.HashMap;
import java.util.Map;

public class java_23513_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_23513_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session Id");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}