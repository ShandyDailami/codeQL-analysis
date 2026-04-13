import java.util.HashMap;
import java.util.Map;

public class java_34458_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_34458_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(sessions.size() + 1);
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}