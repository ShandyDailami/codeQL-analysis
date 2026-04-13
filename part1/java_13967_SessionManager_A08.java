import java.util.HashMap;
import java.util.Map;

public class java_13967_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_13967_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}