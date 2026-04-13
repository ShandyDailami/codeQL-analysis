import java.util.HashMap;
import java.util.Map;

public class java_20140_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20140_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // You can use any session generation logic
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Get user from session
        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User from session: " + userId);

        // Destroy the session
        sessionManager.destroySession(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}