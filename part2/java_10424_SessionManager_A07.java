import java.util.HashMap;
import java.util.Map;

public class java_10424_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_10424_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}