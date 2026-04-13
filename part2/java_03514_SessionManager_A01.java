import java.util.HashMap;
import java.util.Map;

public class java_03514_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_03514_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}