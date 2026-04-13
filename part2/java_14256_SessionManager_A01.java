import java.util.HashMap;

public class java_14256_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_14256_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}