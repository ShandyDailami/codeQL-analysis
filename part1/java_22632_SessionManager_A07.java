import java.util.HashMap;
import java.util.Map;

public class java_22632_SessionManager_A07 {

    private Map<String, String> sessions;

    public java_22632_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String username) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}