import java.util.HashMap;
import java.util.Map;

public class java_22871_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_22871_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }

    public void invalidateSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }
}