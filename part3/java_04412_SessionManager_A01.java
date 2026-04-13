import java.util.HashMap;
import java.util.Map;

public class java_04412_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_04412_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}