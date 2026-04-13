import java.util.HashMap;
import java.util.Map;

public class java_20095_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20095_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null; // Session not found
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}