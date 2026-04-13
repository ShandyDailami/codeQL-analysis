import java.util.HashMap;
import java.util.Map;

public class java_19058_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_19058_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Security-sensitive operation for A01_BrokenAccessControl
    public void changeUser(String sessionId, String newUser) {
        if (sessions.containsKey(sessionId)) {
            sessions.put(sessionId, newUser);
        } else {
            throw new IllegalStateException("Session not found");
        }
    }
}