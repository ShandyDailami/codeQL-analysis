import java.util.HashMap;

public class java_28324_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_28324_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Assuming a unique ID for each session
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