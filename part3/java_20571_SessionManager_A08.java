import java.util.HashMap;
import java.util.Map;

public class java_20571_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_20571_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}