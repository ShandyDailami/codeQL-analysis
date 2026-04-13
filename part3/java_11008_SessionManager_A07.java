import java.util.HashMap;

public class java_11008_SessionManager_A07 {

    private HashMap<String, String> sessions;

    public java_11008_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }
}