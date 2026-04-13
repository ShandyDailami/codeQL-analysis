import java.util.HashMap;
import java.util.Map;

public class java_34925_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_34925_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}