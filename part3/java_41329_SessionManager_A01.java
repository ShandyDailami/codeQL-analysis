import java.util.HashMap;
import java.util.Map;

public class java_41329_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41329_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session ID");
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newData) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session ID");
        }
        sessionMap.replace(sessionId, newData);
    }
}