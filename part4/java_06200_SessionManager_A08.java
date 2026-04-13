import java.util.HashMap;
import java.util.Map;

public class java_06200_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_06200_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public synchronized void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public synchronized void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        }
    }

    public synchronized void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public synchronized String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}