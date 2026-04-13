import java.util.HashMap;
import java.util.Map;

public class java_11976_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11976_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSessionValue(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newValue);
        }
    }
}