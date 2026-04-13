import java.util.HashMap;
import java.util.Map;

public class java_14427_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14427_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionOpen(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}