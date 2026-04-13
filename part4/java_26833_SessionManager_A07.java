import java.util.HashMap;
import java.util.Map;

public class java_26833_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26833_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}