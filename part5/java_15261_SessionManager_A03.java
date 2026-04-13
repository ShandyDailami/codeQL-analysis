import java.util.HashMap;
import java.util.Map;

public class java_15261_SessionManager_A03 {
    private Map<String, Object> sessions;

    public java_15261_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Object getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Object());
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}