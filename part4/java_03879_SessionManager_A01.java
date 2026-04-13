import java.util.HashMap;
import java.util.Map;

public class java_03879_SessionManager_A01 {

    private Map<String, String> sessions;

    public java_03879_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        // Implementation for creating a new session
        this.sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        // Implementation for retrieving a session
        return this.sessions.get(userId);
    }

    public void destroySession(String userId) {
        // Implementation for destroying a session
        this.sessions.remove(userId);
    }

    public void validateSession(String userId, String expectedSessionId) {
        // Implementation for validating a session
        String sessionId = this.sessions.get(userId);
        if (sessionId == null || !sessionId.equals(expectedSessionId)) {
            throw new SecurityException("Invalid session");
        }
    }
}