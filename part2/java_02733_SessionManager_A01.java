import java.util.HashMap;
import java.util.Map;

public class java_02733_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_02733_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id");
        }
    }

    public void destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id");
        }
    }
}