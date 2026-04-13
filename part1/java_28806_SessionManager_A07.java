import java.util.HashMap;
import java.util.Map;

public class java_28806_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_28806_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}