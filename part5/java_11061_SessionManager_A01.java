import java.util.HashMap;
import java.util.Map;

public class java_11061_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_11061_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = "session-" + user;
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }
}