import java.util.HashMap;
import java.util.Map;

public class java_17598_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_17598_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void clearSession() {
        sessionMap.clear();
    }
}