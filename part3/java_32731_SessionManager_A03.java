import java.util.HashMap;

public class java_32731_SessionManager_A03 {
    private HashMap<String, String> sessions;

    public java_32731_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}