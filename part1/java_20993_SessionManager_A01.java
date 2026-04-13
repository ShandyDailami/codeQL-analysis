import java.util.HashMap;
import java.util.Map;

public class java_20993_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_20993_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }
}