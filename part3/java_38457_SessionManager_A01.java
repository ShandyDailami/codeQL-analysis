import java.util.HashMap;
import java.util.Map;

public class java_38457_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38457_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            // Session not found, likely broken
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}