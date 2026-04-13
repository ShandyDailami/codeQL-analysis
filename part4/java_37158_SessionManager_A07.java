import java.util.HashMap;

public class java_37158_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_37158_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
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