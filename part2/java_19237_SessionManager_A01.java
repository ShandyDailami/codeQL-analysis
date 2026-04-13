import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_19237_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19237_SessionManager_A01() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
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