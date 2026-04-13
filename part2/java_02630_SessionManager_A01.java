import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_02630_SessionManager_A01 {
    // ConcurrentHashMap is a thread-safe implementation of HashMap
    private Map<String, String> sessionMap;

    // Initialize sessionMap
    public java_02630_SessionManager_A01() {
        sessionMap = new ConcurrentHashMap<>();
    }

    // Add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Get the userId for a given sessionId
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }
}