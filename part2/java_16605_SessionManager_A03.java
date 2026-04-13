import java.util.HashMap;
import java.util.Map;

public class java_16605_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_16605_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        }
        return null;
    }

    public void destroySession(String userId) {
        sessions.remove(userId);
    }

    public void invalidateSession(String sessionId) {
        for (Map.Entry<String, String> entry : sessions.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                sessions.remove(entry.getKey());
                break;
            }
        }
    }
}