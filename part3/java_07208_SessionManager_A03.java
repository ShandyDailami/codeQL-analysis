import java.util.HashMap;
import java.util.Map;

public class java_07208_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_07208_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}