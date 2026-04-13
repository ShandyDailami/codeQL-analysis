import java.util.HashMap;

public class java_16485_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_16485_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) throws AuthFailure {
        if (!sessions.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session");
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}