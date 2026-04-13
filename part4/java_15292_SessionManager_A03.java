import java.util.HashMap;
import java.util.Map;

public class java_15292_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_15292_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newValue);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}