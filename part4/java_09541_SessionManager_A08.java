import java.util.HashMap;
import java.util.Map;

public class java_09541_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_09541_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }

    public void validateSession(String userId, String sessionId) {
        String storedSessionId = sessions.get(userId);

        if (storedSessionId == null) {
            throw new SecurityException("Invalid session: User has no active session.");
        }

        if (!storedSessionId.equals(sessionId)) {
            throw new SecurityException("Invalid session: Provided session ID does not match stored session ID.");
        }
    }
}