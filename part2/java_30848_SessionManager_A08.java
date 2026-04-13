import java.util.HashMap;
import java.util.Map;

public class java_30848_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_30848_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // for example purposes
        this.sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }
}