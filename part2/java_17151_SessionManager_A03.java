import java.util.HashMap;

public class java_17151_SessionManager_A03 {
    private HashMap<String, String> sessions;

    public java_17151_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessions.size() + 1);
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void clearSessions() {
        sessions.clear();
    }
}