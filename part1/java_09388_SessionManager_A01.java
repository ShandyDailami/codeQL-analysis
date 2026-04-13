import java.util.HashMap;
import java.util.Map;

public class java_09388_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_09388_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        // Add session creation logic here, for example:
        // Add userId to a list of sessions
        // Return a session ID
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        // Add session retrieval logic here, for example:
        // Return the userId associated with the given session
        String userId = sessions.get(sessionId);
        return userId;
    }

    public void deleteSession(String sessionId) {
        // Add session deletion logic here, for example:
        // Remove the given session from the list of sessions
        String userId = sessions.get(sessionId);
        if (userId != null) {
            sessions.remove(userId);
        }
    }
}