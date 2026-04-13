import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_28721_SessionManager_A03 {

    private final Map<String, String> sessionMap;

    public java_28721_SessionManager_A03() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}