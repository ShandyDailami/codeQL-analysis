import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_28523_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28523_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new InvalidParameterException("User ID cannot be null or empty.");
        }

        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new InvalidParameterException("Session ID cannot be null or empty.");
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new InvalidParameterException("Session ID cannot be null or empty.");
        }

        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String userId = "user1";

        // Create a session
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session: " + sessionId);

        // Get the user ID associated with the session
        String associatedUserId = sessionManager.getUserId(sessionId);
        System.out.println("Associated user ID: " + associatedUserId);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}