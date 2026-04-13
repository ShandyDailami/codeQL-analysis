import java.util.HashMap;

public class java_08241_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_08241_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}