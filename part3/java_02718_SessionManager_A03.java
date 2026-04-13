import java.util.HashMap;
import java.util.Map;

public class java_02718_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_02718_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    public void setSession(String sessionId, String sessionData) {
        sessions.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public void clearSessions() {
        sessions.clear();
    }
}