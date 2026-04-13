import java.util.HashMap;
import java.util.Map;

public class java_33511_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33511_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Create a session unique identifier
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Retrieve user id from session
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Remove session from session map
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session with ID: " + sessionId);

        String retrievedUserId = sessionManager.getUserId(sessionId);
        System.out.println("Retrieved user ID: " + retrievedUserId);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session with ID: " + sessionId);
    }
}