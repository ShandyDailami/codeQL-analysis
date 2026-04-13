import java.util.HashMap;
import java.util.Map;

public class java_39625_SessionManager_A03 {

    // This is a simple in-memory implementation of a SessionManager.
    // In a real-world application, this would likely be replaced by a more sophisticated
    // service or an external database service.

    private Map<String, String> sessionMap;

    public java_39625_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}