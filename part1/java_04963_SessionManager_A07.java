import java.util.HashMap;
import java.util.Map;

public class java_04963_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04963_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}