import java.util.HashMap;
import java.util.Map;

public class java_09739_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_09739_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        this.sessions.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        return this.sessions.get(userId);
    }

    public void deleteSession(String userId) {
        this.sessions.remove(userId);
    }

    public void checkSessionIntegrity(String userId) {
        if (!this.sessions.containsKey(userId)) {
            throw new SecurityFailureException("Session integrity failure: User " + userId + " does not have a valid session");
        }
    }
}