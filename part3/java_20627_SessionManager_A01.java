import java.util.HashMap;
import java.util.Map;

public class java_20627_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_20627_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}