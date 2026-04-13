import java.util.HashMap;
import java.util.Map;

public class java_12626_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_12626_SessionManager_A03() {
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

    public void updateSessionValue(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    // added a security sensitive operation: validate session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}