import java.util.HashMap;

public class java_30611_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_30611_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = Integer.toString(sessions.size() + 1);
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }
    }
}