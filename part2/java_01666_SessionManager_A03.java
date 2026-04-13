import java.util.HashMap;
import java.util.Map;

public class java_01666_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_01666_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
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