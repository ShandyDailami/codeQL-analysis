import java.util.HashMap;
import java.util.Map;

public class java_20209_SessionManager_A07 {

    private Map<String, String> sessions;

    public java_20209_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

}