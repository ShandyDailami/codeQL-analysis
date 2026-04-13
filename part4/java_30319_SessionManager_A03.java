import java.util.HashMap;
import java.util.Map;

public class java_30319_SessionManager_A03 {
    private Map<String, Object> sessions;

    public java_30319_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessions.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessions.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}