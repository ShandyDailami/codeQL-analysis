import java.util.HashMap;
import java.util.Map;

public class java_33127_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33127_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public void updateSession(String sessionId, String newSessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionValue);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }
}