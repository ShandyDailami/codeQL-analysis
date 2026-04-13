import java.util.HashMap;
import java.util.Map;

public class java_00560_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_00560_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public void updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newData);
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
}