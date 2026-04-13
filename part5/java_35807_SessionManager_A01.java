import java.util.HashMap;
import java.util.Map;

public class java_35807_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_35807_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}