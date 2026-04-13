import java.util.HashMap;
import java.util.Map;

public class java_41250_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41250_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public synchronized void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public synchronized String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public synchronized void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}