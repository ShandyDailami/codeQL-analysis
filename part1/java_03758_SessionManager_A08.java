import java.util.HashMap;
import java.util.Map;

public class java_03758_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_03758_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = Integer.toString(user.hashCode());
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Session not found");
        }
    }
}