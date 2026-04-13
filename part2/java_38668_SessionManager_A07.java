import java.util.HashMap;
import java.util.Map;

public class java_38668_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_38668_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void addSession(String username, String sessionId) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}