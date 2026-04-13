import java.util.HashMap;
import java.util.Map;

public class java_13257_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_13257_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void destroySession(String userId) {
        sessions.remove(userId);
    }
}