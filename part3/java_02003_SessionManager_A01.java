import java.util.HashMap;
import java.util.Map;

public class java_02003_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02003_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}