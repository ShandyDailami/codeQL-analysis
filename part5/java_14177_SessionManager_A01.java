import java.util.HashMap;
import java.util.Map;

public class java_14177_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14177_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}