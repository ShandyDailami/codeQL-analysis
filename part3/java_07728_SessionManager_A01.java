import java.util.HashMap;
import java.util.Map;

public class java_07728_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07728_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }
}