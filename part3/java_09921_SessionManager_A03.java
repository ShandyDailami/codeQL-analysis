import java.util.HashMap;

public class java_09921_SessionManager_A03 {
    private HashMap<String, String> sessions;

    public java_09921_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }
}