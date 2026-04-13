import java.util.HashMap;

public class java_11381_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_11381_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void invalidateAllSessions() {
        sessions.clear();
    }
}