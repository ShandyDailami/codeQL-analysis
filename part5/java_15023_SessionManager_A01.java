import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_15023_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15023_SessionManager_A01() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}