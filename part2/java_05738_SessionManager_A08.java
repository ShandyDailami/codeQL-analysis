import java.util.HashMap;
import java.util.Map;

public class java_05738_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_05738_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionData);
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

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }
}