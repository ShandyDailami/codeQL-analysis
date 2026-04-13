import java.util.HashMap;
import java.util.Map;

public class java_06880_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_06880_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
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

    public void updateSession(String sessionId, String newSessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newSessionValue);
        }
    }
}