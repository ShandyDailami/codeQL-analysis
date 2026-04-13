import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_32584_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_32584_SessionManager_A08() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(String sessionId, String userId) {
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