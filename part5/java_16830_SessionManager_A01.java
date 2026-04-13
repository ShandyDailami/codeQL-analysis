import java.util.HashMap;
import java.util.Map;

public class java_16830_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_16830_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String user, String sessionId) {
        sessions.put(sessionId, user);
    }

    public String getSessionUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}