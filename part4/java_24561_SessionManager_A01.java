import java.util.HashMap;
import java.util.Map;

public class java_24561_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_24561_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
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

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        }
    }
}