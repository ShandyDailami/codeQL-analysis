import java.util.HashMap;
import java.util.Map;

public class java_13791_SessionManager_A01 {

    private Map<String, String> sessions;

    public java_13791_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}