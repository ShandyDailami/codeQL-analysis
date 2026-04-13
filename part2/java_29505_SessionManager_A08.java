import java.util.HashMap;
import java.util.Map;

public class java_29505_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29505_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            return this.sessionMap.get(sessionId);
        }
        return null;
    }

    public void removeSession(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.remove(sessionId);
        }
    }

    public boolean isValidSession(String sessionId) {
        return this.sessionMap.containsKey(sessionId);
    }
}