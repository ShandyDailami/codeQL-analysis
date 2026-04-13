import java.util.HashMap;
import java.util.Map;

public class java_23286_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23286_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}