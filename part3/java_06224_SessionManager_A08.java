import java.util.HashMap;

public class java_06224_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_06224_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: session not found");
        }
    }
}