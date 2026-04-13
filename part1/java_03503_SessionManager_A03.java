import java.util.HashMap;
import java.util.Map;

public class java_03503_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03503_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}