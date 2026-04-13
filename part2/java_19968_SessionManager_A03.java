import java.util.HashMap;
import java.util.Map;

public class java_19968_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19968_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}