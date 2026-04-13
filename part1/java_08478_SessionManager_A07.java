import java.util.HashMap;
import java.util.Map;

public class java_08478_SessionManager_A07 {
    // This is a simple in-memory map that will hold our sessions.
    // In a real-world scenario, this would be replaced with a database.
    private Map<String, String> sessions = new HashMap<>();

    // This method will be used to create a new session.
    public String createSession(String userId) {
        // In a real-world scenario, this would be a secure authentication process.
        // This is a placeholder and will not actually authenticate the user.
        if (userId != null && !userId.isEmpty()) {
            String sessionId = userId + "_" + System.currentTime();
            sessions.put(sessionId, userId);
            return sessionId;
        }

        return null;
    }

    // This method will be used to get the user for a given session.
    public String getUserForSession(String sessionId) {
        // In a real-world scenario, this would be a secure authentication process.
        // This is a placeholder and will not actually get the user from the session.
        if (sessionId != null && !sessionId.isEmpty()) {
            return sessions.get(sessionId);
        }

        return null;
    }
}