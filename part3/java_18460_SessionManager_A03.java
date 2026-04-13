import java.util.HashMap;
import java.util.Map;

public class java_18460_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18460_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return null;
        } else {
            sessionMap.put(sessionId, sessionId);
            return sessionId;
        }
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}