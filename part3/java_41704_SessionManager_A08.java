import java.util.HashMap;
import java.util.Map;

public class java_41704_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41704_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // for simplicity, we're using userId and current time in session ID
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}