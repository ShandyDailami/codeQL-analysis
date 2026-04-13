import java.util.HashMap;
import java.util.Map;

public class java_02980_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02980_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String newSessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionValue);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }
}