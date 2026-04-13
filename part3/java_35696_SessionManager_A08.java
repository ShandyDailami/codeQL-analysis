import java.util.HashMap;

public class java_35696_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_35696_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getSessionUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Invalid session id");
        }
    }
}