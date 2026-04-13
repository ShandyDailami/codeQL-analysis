import java.util.HashMap;
import java.util.Map;

public class java_01520_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_01520_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}