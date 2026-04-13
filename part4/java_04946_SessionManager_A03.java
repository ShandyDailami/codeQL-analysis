import java.util.HashMap;
import java.util.Map;

public class java_04946_SessionManager_A03 {

    private Map<String, String> sessions;

    public java_04946_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessions.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String sessionData) {
        if (sessions.containsKey(sessionId)) {
            sessions.put(sessionId, sessionData);
        }
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}