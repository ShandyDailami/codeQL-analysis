import java.util.HashMap;
import java.util.Map;

public class java_33283_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33283_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String sessionKey) {
        return sessionMap.get(sessionKey);
    }

    public void setSessionId(String sessionKey, String sessionId) {
        sessionMap.put(sessionKey, sessionId);
    }

    public void invalidateSession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }
}