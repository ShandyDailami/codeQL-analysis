import java.util.Map;
import java.util.HashMap;

public class java_28916_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28916_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session " + sessionId + " already exists!");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session " + sessionId + " does not exists!");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session " + sessionId + " does not exists!");
        }
        sessionMap.remove(sessionId);
    }
}