import java.util.HashMap;
import java.util.Map;

public class java_38514_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_38514_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session ID");
        }
        sessionMap.remove(sessionId);
    }
}