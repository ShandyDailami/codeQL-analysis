import java.util.HashMap;
import java.util.Map;

public class java_21711_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_21711_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}