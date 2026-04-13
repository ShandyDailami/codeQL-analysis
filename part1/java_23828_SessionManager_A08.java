import java.util.HashMap;

public class java_23828_SessionManager_A08 {
    private HashMap<String, Object> sessions;

    public java_23828_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Object getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID: " + sessionId);
        }
    }

    public void setSession(String sessionId, Object sessionObject) {
        sessions.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session ID: " + sessionId);
        }
    }
}