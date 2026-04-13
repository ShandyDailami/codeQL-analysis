import java.util.HashMap;
import java.util.Map;

public class java_04983_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_04983_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }
}