import java.util.HashMap;
import java.util.Map;

public class java_18079_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18079_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}