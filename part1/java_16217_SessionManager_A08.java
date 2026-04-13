import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_16217_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16217_SessionManager_A08() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}