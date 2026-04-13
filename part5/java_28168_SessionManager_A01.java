import java.util.HashMap;

public class java_28168_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_28168_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessions.put(sessionId, sessionId);
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}