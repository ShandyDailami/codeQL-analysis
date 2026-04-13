import java.util.HashMap;

public class java_28253_SessionManager_A03 {

    private HashMap<String, String> sessions;

    public java_28253_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}