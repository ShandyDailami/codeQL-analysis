import java.util.HashMap;
import java.util.Map;

public class java_22929_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22929_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}