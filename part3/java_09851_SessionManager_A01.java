import java.util.HashMap;

public class java_09851_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_09851_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}