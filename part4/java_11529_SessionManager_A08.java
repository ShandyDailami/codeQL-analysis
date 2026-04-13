import java.util.HashMap;
import java.util.Map;

public class java_11529_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11529_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}