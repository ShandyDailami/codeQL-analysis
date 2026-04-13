import java.util.HashMap;
import java.util.Map;

public class java_07432_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_07432_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}