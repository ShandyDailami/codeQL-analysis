import java.util.HashMap;

public class java_08517_SessionManager_A07 {
    private HashMap<String, Object> sessions;

    public java_08517_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessions.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}