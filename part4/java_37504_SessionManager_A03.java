import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_37504_SessionManager_A03 {
    // Use ConcurrentHashMap for session storage
    private Map<String, Object> sessionMap;

    public java_37504_SessionManager_A03() {
        sessionMap = new ConcurrentHashMap<>();
    }

    // Session creation
    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    // Session retrieval
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session deletion
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}