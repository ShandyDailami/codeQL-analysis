import java.util.HashMap;
import java.util.Map;

public class java_17141_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_17141_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        }
    }
}