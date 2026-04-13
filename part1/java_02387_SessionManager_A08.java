import java.util.HashMap;
import java.util.Map;

public class java_02387_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_02387_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
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