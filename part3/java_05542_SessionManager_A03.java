import java.util.HashMap;
import java.util.Map;

public class java_05542_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05542_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }
}