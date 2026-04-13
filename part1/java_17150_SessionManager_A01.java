import java.util.HashMap;

public class java_17150_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_17150_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}