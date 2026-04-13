import java.util.HashMap;
import java.util.Map;

public class java_36778_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36778_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // This is a very basic session creation. In a real application, session should be created with a unique key (like UUID) and userId should be used to generate a sessionId.
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